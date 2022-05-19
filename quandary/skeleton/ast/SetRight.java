package ast;

import java.util.Map;
import java.util.Queue;

public class SetRight extends Function {

    public SetRight(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qval result = new Qval(1);
        Qref temp = (Qref) parameter.poll();
        Qtype change = parameter.poll();
        temp.right = change;

        return result;
    }
}
