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
    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qval temp = (Qval) expr.eval(allFunc, env);
        return new Qval(-(temp.value()));
    }

}
