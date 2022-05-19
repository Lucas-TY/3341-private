package ast;

import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class RandomInt extends Function {

    public RandomInt(Location loc) {
        super(loc);
    }

    public Qval exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Random output = new Random();
        Qval temp = (Qval) parameter.poll();
        Long input = temp.value;
        int result = output.nextInt(input.intValue());
        return new Qval((long) result);
    }
}
