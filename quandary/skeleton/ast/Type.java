package ast;

public class Type extends ASTNode {
    public static final int INT = 1;
    public static final int REF = 2;
    public static final int Q = 3;

    final int typeVal;

    public Type(int operator, Location loc) {
        super(loc);
        this.typeVal = operator;

    }

    public Qtype declare() {
        switch (typeVal) {
            case INT:
                return new Qval();
            case REF:
                return new Qref("nil");
            case Q:
                return new Qref("nil");
        }
        throw new RuntimeException("Unexpected in Type.declare");
    }
}
