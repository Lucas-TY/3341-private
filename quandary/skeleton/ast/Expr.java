package ast;

import java.util.Map;

public abstract class Expr extends ASTNode {

    Expr(Location loc) {
        super(loc);
    }

    abstract Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env);
}
