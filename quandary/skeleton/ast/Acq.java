
package ast;

import java.util.Map;
import java.util.Queue;

public class Acq extends Function {

    public Acq(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qtype temp = parameter.poll();
        
        return new Qval(temp.lock());
    }
}
