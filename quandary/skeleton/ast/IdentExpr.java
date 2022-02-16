package ast;

import java.util.Map;

public class IdentExpr extends Expr {
    String name;

    public IdentExpr(String name, Location loc) {
        super(loc);
        this.name = name;
    }

    public Qval eval(Map<String, Qtype> env) {

        return (Qval) env.get(this.name);
    }
}
