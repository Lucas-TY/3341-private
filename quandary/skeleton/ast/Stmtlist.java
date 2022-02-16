package ast;

import java.util.*;

public class Stmtlist extends Stmt {
    final Stmtlist rest;
    final Stmt first;
    Qtype result = null;

    public Stmtlist(Stmt first, Stmtlist stmtlist, Location loc) {
        super(loc);
        this.first = first;
        this.rest = stmtlist;

    }

    public Qtype execute(Map<String, Qtype> env) {
        this.result = first.execute(env);
        if (this.result != null) {
            return this.result;
        } else if (this.rest != null) {
            return rest.execute(env);
        }
        return null;

    }

}
