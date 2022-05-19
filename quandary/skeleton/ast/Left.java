package ast;

import java.util.Map;
import java.util.Queue;

public class Left extends Function {

    public Left(Location loc) {
        super(loc);
    }

    public Qtype exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {  
        Qref temp = (Qref) parameter.poll();
        return temp.left;
    }
}
