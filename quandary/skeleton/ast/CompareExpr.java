package ast;

import java.util.Map;

public class CompareExpr extends Cond {
    public static final int ELARGER = 1;
    public static final int ESMALLER = 2;
    public static final int EQUAL = 3;
    public static final int NOTEQAUL = 4;
    public static final int LARGER = 5;
    public static final int SMALLER = 6;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public CompareExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    public String toString(Map<String, Qtype> env) {
        return "(" + simpleString(env) + ")";
    }

    public String simpleString(Map<String, Qtype> env) {
        String s = null;
        switch (operator) {
            case ELARGER:
                s = ">=";
                break;
            case ESMALLER:
                s = "<=";
                break;
            case EQUAL:
                s = "==";
                break;
            case NOTEQAUL:
                s = "!=";
                break;
            case LARGER:
                s = ">";
                break;
            case SMALLER:
                s = "<";
                break;
        }
        return expr1.eval(env).value + " " + s + " " + expr2.eval(env).value;
    }

    @Override
    public boolean eval(Map<String, Qtype> env) {

        switch (operator) {
            case ELARGER:
                return Qval.minus(expr1.eval(env), expr2.eval(env)).value >= 0;
            case ESMALLER:
                return Qval.minus(expr1.eval(env), expr2.eval(env)).value <= 0;
            case EQUAL:
                return expr1.eval(env).value.equals(expr2.eval(env).value);
            case NOTEQAUL:
                return expr1.eval(env).value != expr2.eval(env).value;
            case LARGER:
                return expr1.eval(env).value > expr2.eval(env).value;

            case SMALLER:
                return expr1.eval(env).value < expr2.eval(env).value;

        }
        throw new RuntimeException("Unexpected in CompareExpr.doOperation");
    }

}
