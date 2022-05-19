
package ast;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class FuncDef extends Function {
    final VarDecl varD;
    final FormalDeclList Decl;
    final Stmtlist sl;

    public FuncDef(VarDecl var, FormalDeclList Decl, Stmtlist sl, Location loc) {
        super(loc);
        this.varD = var;
        this.Decl = Decl;
        this.sl = sl;
    }

    public Qtype exec(Map<String, Function> allFunc, Queue<Qtype> parameter) {
        Map<String, Qtype> env = new ConcurrentHashMap<>();
        if (this.Decl != null) {
            env = this.Decl.load(parameter);
        } else {
            env = new HashMap<>();
        }
        return this.sl.execute(allFunc, env);
    }

    public void load(Map<String, Type> allFunc) {
        allFunc.put(this.varD.name, this.varD.type);
    }
}
