package ast;

import java.util.Map;

public class LogicCond extends Cond {
    public static final int AND = 1;
    public static final int OR = 2;

    final Cond cond1;
    final int operator;
    final Cond cond2;

    public LogicCond(Cond cond1, int operator, Cond cond2, Location loc) {
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
    public boolean eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        switch (operator) {
            case AND:
                return cond1.eval(allFunc, env) && cond2.eval(allFunc, env);
            case OR:
                return cond1.eval(allFunc, env) || cond2.eval(allFunc, env);
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }

}
