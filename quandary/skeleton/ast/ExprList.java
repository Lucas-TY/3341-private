package ast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class ExprList extends ASTNode {
    final NeExprList neList;

    public ExprList(NeExprList neList, Location loc) {
        super(loc);
        this.neList = neList;
    }

    public Queue<Qtype> load(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Queue<Qtype> result = new LinkedList<>();
        this.neList.load(allFunc, result, env);
        return result;
    }
}