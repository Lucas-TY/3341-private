package ast;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Qval extends Qtype {
    long value;
    private final Lock Qlock = new ReentrantLock();




    public Qval(long value) {
        this.value = value;
    }

    public Qval() {
    }

    public long lock() {
        while (!this.Qlock.tryLock()) {
            System.out.println("waitting");
        }
        return 1;
    }
    public void unlock(){
        this.Qlock.unlock();
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

    public Long value() {
        return this.value;
    }

    public boolean equals(Qval q1) {
        return this.value == q1.value;
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
