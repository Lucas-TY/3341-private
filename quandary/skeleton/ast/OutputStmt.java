package ast;

import java.util.*;

public class OutputStmt extends Stmt {
    public static final int PRINT = 1;
    public static final int RETURN = 2;

    final Expr expr;
    final int operator;

    public OutputStmt(Expr expr, int operator, Location loc) {
        super(loc);
        this.expr = expr;
        this.operator = operator;
    }

    @Override
    public Qtype execute(Map<String, Qtype> env) {
        switch (operator) {
            case PRINT:
                System.out.println(this.expr.eval(env).toString());
                return null;
            case RETURN:
                return this.expr.eval(env);

        }
        return null;

    }

}
