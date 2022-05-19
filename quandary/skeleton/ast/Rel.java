
package ast;

import java.util.Map;
import java.util.Queue;

public class Rel extends Function {

    public Rel(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qtype temp = parameter.poll();
        temp.unlock();
        return new Qval(1);
    }
}
