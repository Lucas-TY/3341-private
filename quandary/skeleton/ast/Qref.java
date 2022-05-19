package ast;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Qref extends Qtype {
    Qtype left;
    Qtype right;
    boolean isNil;
    private final Lock Qlock = new ReentrantLock();

    public Qref(Qtype left, Qtype right) {
        this.left = left;
        this.right = right;
        this.isNil = false;
    }

    public Qref(String nil) {
        this.isNil = true;
    }

    public long lock() {
        while (!this.Qlock.tryLock()) {
            System.out.println("waitting");
        }
        return 1;
    }

    public void unlock() {
        this.Qlock.unlock();
    }
    
    public boolean isNil() {
        return this.isNil;
    }

    @Override
    public String toString() {
        if (this.left == null) {
            return "nil";
        }
        return "(" + this.left.toString() + " . " + right.toString() + ")";
    }

}
