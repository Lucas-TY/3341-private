package ast;

import java.util.Map;
import java.util.Queue;

public class SetLeft extends Function {

    public SetLeft(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qval result = new Qval(1);
        Qref temp = (Qref) parameter.poll();
        Qtype change = parameter.poll();
        temp.left = change;

        return result;
    }
}
