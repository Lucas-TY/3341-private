package ast;

import java.util.Map;

public class BinaryExpr extends Expr {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int REF = 4;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public BinaryExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case PLUS:
                s = "+";
                break;
            case MINUS:
                s = "-";
                break;
            case TIMES:
                s = "*";
                break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        long result;
        Qval left = (Qval) expr1.eval(allFunc, env);
        Qval right = (Qval) expr2.eval(allFunc, env);
        switch (operator) {
            case PLUS:

                result = left.value() + right.value();
                return new Qval(result);
            case MINUS:
                result = left.value() - right.value();
                return new Qval(result);
            case TIMES:
                result = left.value() * right.value();
                return new Qval(result);

        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }

}
