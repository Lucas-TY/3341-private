package ast;

public class VarDecl extends ASTNode {
    final Type type;
    final String name;

    public VarDecl(Type ty, String name, Location loc) {
        super(loc);
        this.type = ty;
        this.name = name;
    }
}
