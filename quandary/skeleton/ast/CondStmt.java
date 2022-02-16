package ast;

import java.util.*;

public class CondStmt extends Stmt {

    public static final int IF = 1;
    public static final int ELSE = 2;

    final Cond condition1;
    final Cond condition2;
    final int operator;
    final Stmt s1;
    final Stmt s2;
    final Stmt s3;

    public CondStmt(Cond c1, int operator, Stmt s1, Location loc) {
        super(loc);
        this.condition1 = c1;
        this.condition2 = null;
        this.operator = operator;
        this.s1 = s1;
        this.s2 = null;
        this.s3 = null;
    }

    public CondStmt(Cond c1, Cond c2, int operator, Stmt s1, Stmt s2, Location loc) {
        super(loc);
        this.condition1 = c1;
        this.condition2 = c2;
        this.operator = operator;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = null;
    }

    public CondStmt(Cond c1, int operator, Stmt s1, Stmt s2, Location loc) {
        super(loc);
        this.condition1 = c1;
        this.condition2 = null;
        this.operator = operator;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = null;
    }

    @Override
    public Qtype execute(Map<String, Qtype> env) {
        Qtype result;
        switch (this.operator) {
            case IF:
                if (condition1.eval(env)) {
                    result = this.s1.execute(env);
                    if (result != null) {
                        return result;
                    }
                }
                break;
            case ELSE:
                if (condition1.eval(env)) {
                    result = this.s1.execute(env);
                    if (result != null) {
                        return result;
                    }
                } else {
                    result = this.s2.execute(env);
                    if (result != null) {
                        return result;
                    }
                }
                break;

        }
        return null;

    }
}
