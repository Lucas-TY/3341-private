package ast;

import java.util.*;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class DeclStmt extends Stmt {

    final VarDecl ident;
    final Expr expr;

    public DeclStmt(VarDecl ident, Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
        this.ident = ident;
    }

    @Override
    public Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env) {
        String name = this.ident.name;
        Qtype item = this.ident.type.declare();
        item = expr.eval(allFunc, env);
        env.put(name, item);
        return null;
    }

}
