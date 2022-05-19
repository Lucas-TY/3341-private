
package ast;

import java.util.Queue;
import java.util.Map;

public class NeFormalDeclList extends ASTNode {
    final VarDecl vardecl;
    final NeFormalDeclList rest;

    public NeFormalDeclList(VarDecl var, NeFormalDeclList rest, Location loc) {
        super(loc);
        this.rest = rest;
        this.vardecl = var;
    }

    public void load(Map<String, Qtype> env, Queue<Qtype> parameter) {
        Qtype item = parameter.poll();
        String name = this.vardecl.name;
        env.put(name, item);
        if (this.rest != null) {
            this.rest.load(env, parameter);
        }
    }
}