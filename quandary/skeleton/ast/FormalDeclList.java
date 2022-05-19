package ast;

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;

public class FormalDeclList extends ASTNode {
    final NeFormalDeclList neList;

    public FormalDeclList(NeFormalDeclList neList, Location loc) {
        super(loc);
        this.neList = neList;
    }

    public Map<String, Qtype> load(Queue<Qtype> parameter) {
        Map<String, Qtype> result = new HashMap<>();
        this.neList.load(result, parameter);
        return result;

    }

}
