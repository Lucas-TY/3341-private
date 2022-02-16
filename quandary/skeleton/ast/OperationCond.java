package ast;

import java.util.Map;

public class OperationCond extends Cond {
    public static final int AND = 1;
    public static final int OR = 2;

    final Cond cond1;
    final int operator;
    final Cond cond2;

    public OperationCond(Cond cond1, int operator, Cond cond2, Location loc) {
        super(loc);
        this.cond1 = cond1;
        this.operator = operator;
        this.cond2 = cond2;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case AND:
                s = "&&";
                break;
            case OR:
                s = "||";
                break;
        }
        return cond1 + " " + s + " " + cond2;

    }

    @Override
    public boolean eval(Map<String, Qtype> env) {
        switch (operator) {
            case AND:
                return cond1.eval(env) && cond2.eval(env);
            case OR:
                return cond1.eval(env) || cond2.eval(env);
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }

}
