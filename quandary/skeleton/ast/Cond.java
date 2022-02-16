package ast;

import java.util.Map;

public abstract class Cond extends ASTNode {

    Cond(Location loc) {
        super(loc);
    }

    abstract boolean eval(Map<String, Qtype> env);
}
