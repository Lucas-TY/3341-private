package ast;

import java.util.Queue;
import java.util.Map;

public class NeExprList extends ASTNode {
    final Expr e1;
    final NeExprList neList;

    public NeExprList(Expr expr, NeExprList neList, Location loc) {
        super(loc);
        this.e1 = expr;
        this.neList = neList;
    }

    public void load(Map<String, Function> allFunc, Queue<Qtype> list, Map<String, Qtype> env) {
        list.add(e1.eval(allFunc, env));
        if (this.neList != null) {
            this.neList.load(allFunc, list, env);
        }
    }

}
