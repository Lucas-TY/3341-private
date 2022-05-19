package ast;

import java.util.Map;

public class ConditionExpr extends Cond {
    public static final int ELARGER = 1;
    public static final int ESMALLER = 2;
    public static final int EQUAL = 3;
    public static final int NOTEQAUL = 4;
    public static final int LARGER = 5;
    public static final int SMALLER = 6;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public ConditionExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;

    }

    public String toString(Map<String, Function> allFunc, Map<String, Qtype> env) {
        return "(" + simpleString(allFunc, env) + ")";
    }

    public String simpleString(Map<String, Function> allFunc, Map<String, Qtype> env) {
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
        return expr1.eval(allFunc, env).value + " " + s + " " + expr2.eval(allFunc, env).value;
    }

    @Override
    public boolean eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qval left = (Qval) expr1.eval(allFunc, env);
        Qval right = (Qval) expr2.eval(allFunc, env);

        switch (operator) {
            case ELARGER:
                return left.value() >= right.value();
            case ESMALLER:
                return left.value() <= right.value();
            case EQUAL:
                return (long) left.value() == (long) right.value();
            case NOTEQAUL:
                return left.value() != right.value();
            case LARGER:
                return left.value() > right.value();

            case SMALLER:
                return left.value() < right.value();

        }
        throw new RuntimeException("Unexpected in ConditionExpr.doOperation");
    }

}
