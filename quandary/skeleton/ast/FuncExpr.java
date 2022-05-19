
package ast;

import java.util.*;

public class FuncExpr extends Expr {

    final ExprList exprList;
    final String callName;

    public FuncExpr(String name, ExprList epList, Location loc) {
        super(loc);
        this.callName = name;
        this.exprList = epList;
    }

    @Override
    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        Function callFunc = allFunc.get(this.callName);
        Queue<Qtype> parameter;
        if (this.exprList != null) {
            parameter = this.exprList.load(allFunc, env);
        } else {
            parameter = new LinkedList<>();
        }
        return callFunc.exec(allFunc, parameter);
    }

}
