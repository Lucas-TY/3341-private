package ast;

public class UminusExpr extends Expr {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;

    final Expr expr;

    public UminusExpr(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "-" + " " + "(" + expr + ")";
    }

    @Override
    Object eval() {
        return -(long) expr.eval();
    }

}
