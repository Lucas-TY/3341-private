package ast;

import java.util.Map;

public class NotCond extends Cond {
    final Cond expr;

    public NotCond(Cond expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    public boolean eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        return !expr.eval(allFunc, env);

    }

}
