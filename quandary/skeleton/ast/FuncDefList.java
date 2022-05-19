
package ast;

import java.util.Map;

public class FuncDefList extends ASTNode {
    final FuncDef first;
    final FuncDefList rest;

    public FuncDefList(FuncDef first, FuncDefList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest;
    }

    public void load(Map<String, Function> allFunc) {
        String name = this.first.varD.name;
        allFunc.put(name, this.first);
        if (this.rest != null) {
            this.rest.load(allFunc);
        }

    }

}
