
package ast;

import java.util.*;

public class UpdateStmt extends Stmt {

    final String name;
    final Expr expr;

    public UpdateStmt(String name, Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
        this.name = name;
    }

    @Override
    public Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qtype item = expr.eval(allFunc, env);
        env.put(name, item);
        return null;
    }

}
