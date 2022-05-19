package ast;

import java.util.*;

public class WhileStmt extends Stmt {

    final Cond condition1;
    final Stmt s1;

    public WhileStmt(Cond c1, Stmt s1, Location loc) {
        super(loc);
        this.condition1 = c1;
        this.s1 = s1;

    }

    @Override
    public Qtype execute(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Qtype result = null;
        
        while (condition1.eval(allFunc, env)) {
            if (result == null) {
                if(this.s1!=null){
                    result = this.s1.execute(allFunc, env);
                }
               
                
            } else {
                return result;
            }
        }

        return null;

    }
}
//boolean runWhile = condition1.eval(allFunc, env);