package ast;

import java.util.*;

public abstract class Stmt extends ASTNode {
    Stmt(Location loc) {
        super(loc);
    }

    abstract Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env);

}
