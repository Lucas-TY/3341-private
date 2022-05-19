package ast;

import java.util.Map;

public class ConstExpr extends Expr {

    final Qval value;

    public ConstExpr(long value, Location loc) {
        super(loc);
        this.value = new Qval(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Qval eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        return value;
    }
}
