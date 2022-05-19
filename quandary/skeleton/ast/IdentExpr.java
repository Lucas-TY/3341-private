package ast;

import java.util.Map;

public class IdentExpr extends Expr {
    final String name;

    public IdentExpr(String name, Location loc) {
        super(loc);
        this.name = name;
    }

    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        return env.get(this.name);
    }
}
