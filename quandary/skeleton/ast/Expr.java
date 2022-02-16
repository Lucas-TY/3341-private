package ast;

import java.util.Map;

public abstract class Expr extends ASTNode {

    Expr(Location loc) {
        super(loc);
    }

    abstract Qval eval(Map<String, Qtype> env);
}
