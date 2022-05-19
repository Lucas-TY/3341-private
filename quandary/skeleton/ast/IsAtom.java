package ast;

import java.util.Map;
import java.util.Queue;

public class IsAtom extends Function {

    public IsAtom(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qtype temp = parameter.poll();
        try {
            Qref temp2 = (Qref) temp;
            if (temp2.isNil() == false) {
                return new Qval(0);
            }

        } catch (Exception e) {
            return new Qval(1);
        }
        return new Qval(1);
    }
}
