package ast;

import java.util.*;

public class Stmtlist extends Stmt {
    final Stmtlist rest;
    final Stmt first;

    public Stmtlist(Stmt first, Stmtlist stmtlist, Location loc) {
        super(loc);
        this.first = first;
        this.rest = stmtlist;

    }

    @Override
    public Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qtype result = first.execute(allFunc, env);
        if (result != null) {
            return result;
        } else if (this.rest != null) {
            return rest.execute(allFunc, env);
        }
        return null;

    }

}
