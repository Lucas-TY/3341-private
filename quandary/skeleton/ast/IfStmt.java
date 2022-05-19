package ast;

import java.util.*;

public class IfStmt extends Stmt {

    final Cond condition1;
    final Stmt s1;
    final Stmt s2;

    public IfStmt(Cond c1, Stmt s1, Stmt s2, Location loc) {
        super(loc);
        this.condition1 = c1;
        this.s1 = s1;
        this.s2 = s2;

    }

    @Override
    public Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env) {

        if (condition1.eval(allFunc, env)) {
            if (this.s1 != null) {
                return this.s1.execute(allFunc, env);
            }
        }

        else if (this.s2 != null) {
            return this.s2.execute(allFunc, env);

        }

        return null;

    }
}
