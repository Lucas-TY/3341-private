package ast;

import java.util.*;

public class ExecuStmt extends Stmt {
    public static final int DECLARE = 1;
    public static final int UPDATE = 2;

    final String ident;
    final Expr expr;
    final int operator;

    public ExecuStmt(String ident, Expr expr, int operator, Location loc) {
        super(loc);
        this.expr = expr;
        this.ident = ident;
        this.operator = operator;
    }

    @Override
    Qtype execute(Map<String, Qtype> env) {
        switch (operator) {
            case DECLARE:
                env.put(this.ident, (expr.eval(env)));
            case UPDATE:
                env.put(this.ident, (expr.eval(env)));

        }

        return null;
    }

}
