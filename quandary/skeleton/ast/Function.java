package ast;

import java.util.Map;
import java.util.Queue;

public abstract class Function extends ASTNode {
    Function(Location loc) {
        super(loc);
    }

    abstract Qtype exec(Map<String, Function> allFunc, Queue<Qtype> parameter);

}
