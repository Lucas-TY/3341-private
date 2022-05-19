package ast;
import java.util.concurrent.locks.Lock;



public abstract class Qtype {
    long value;

    public abstract String toString();
    public abstract long lock();
    public abstract void unlock();
    
}
