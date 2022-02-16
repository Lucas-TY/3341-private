package ast;

import java.util.Map;

public class NotCond extends Cond {
    private final Cond expr;

    public NotCond(Cond expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    public boolean eval(Map<String, Qtype> env) {
        return !expr.eval(env);

    }

}
