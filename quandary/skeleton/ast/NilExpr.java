package ast;

import java.util.Map;

public class NilExpr extends Expr {

    public NilExpr(Location loc) {
        super(loc);
    }

    @Override
    public String toString() {
        return "nil";
    }

    @Override
    public Qref eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        return new Qref("nil");
    }
}
