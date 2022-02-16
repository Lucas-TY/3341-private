package ast;

import java.util.AbstractQueue;
import java.util.Map;

public class Qval extends Qtype {
    final Long value;

    public Qval(long value) {
        this.value = value;
    }

    public boolean equals(Qtype compare, Map<String, Qtype> env) {
        boolean result = false;
        System.out.println("result: " + (this.value - compare.value(env)));
        result = (this.value - compare.value(env) == 0);
        return result;
    }

    public Long value(Map<String, Qtype> env) {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static Qval plus(Qval q1, Qval q2) {
        long result = q1.value + q2.value;
        return new Qval(result);
    }

    public static Qval minus(Qval q1, Qval q2) {
        long result = q1.value - q2.value;
        return new Qval(result);
    }

    public static Qval times(Qval q1, Qval q2) {
        long result = q1.value * q2.value;
        return new Qval(result);
    }

}
