package ast;

import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class IsNil extends Function {

    public IsNil(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Qtype temp = parameter.poll();
        try {
            Qref temp2 = (Qref) temp;
            if (temp2.isNil() == true) {
                return new Qval(1);
            }

        } catch (Exception e) {
            return new Qval(0);
        }

        return new Qval(0);
    }
}
