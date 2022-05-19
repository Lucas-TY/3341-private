package ast;

import java.util.Map;

public class RefExpr extends BinaryExpr {
    public static final int REF = 4;
    
    final Expr left;
    final Expr right;
    final int operator;

    public RefExpr(Expr expr1,int operator, Expr expr2, Location loc) {
        super(expr1,operator,expr2,loc);
        this.left = expr1;
        this.right = expr2;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {

        return "(" + left.toString() + " . " + right.toString() + ")";
    }

    @Override
    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qref result = new Qref(this.left.eval(allFunc, env), this.right.eval(allFunc, env));
        return result;

    }

}
