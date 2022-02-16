package ast;

import java.util.Map;

public class UminusExpr extends Expr {

    final Expr expr;

    public UminusExpr(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "-(" + expr + ")";
    }

    @Override
    public Qval eval(Map<String, Qtype> env) {
        System.out.println("read :" + -expr.eval(env).value);
        return new Qval((-expr.eval(env).value));
    }

}
