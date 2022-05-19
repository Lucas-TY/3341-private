package ast;

import java.util.*;
import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;

public class Program extends ASTNode {
    /* new Program(arg,sl,loc(eleft,eright)); */
    final Map<String, Function> allFunc;
    final FuncDefList function;

    public Program(FuncDefList function, Location loc) {
        super(loc);

        this.function = function;
        this.allFunc = new ConcurrentHashMap<String, Function>();
    }

    public void println(PrintStream ps) {
        ps.println("stmt");
    }

    public Qtype exec(long argument) {
        /* load all function in this program */
        this.builtIn();
        this.function.load(allFunc);

        Function main = this.allFunc.get("main");
        Queue<Qtype> initparameter = new LinkedList<>();
        Qtype item = new Qval(argument);
        initparameter.add(item);
        return main.exec(allFunc, initparameter);

    }

    public void builtIn() {
        Function randomInt = new RandomInt(loc);
        Function setRight = new SetRight(loc);
        Function setLeft = new SetLeft(loc);
        Function isAtom = new IsAtom(loc);
        Function isNil = new IsNil(loc);
        Function right = new Right(loc);
        Function left = new Left(loc);
        Function acq = new Acq(loc);
        Function rel = new Rel(loc);
        this.allFunc.put("randomInt", randomInt);
        this.allFunc.put("setRight", setRight);
        this.allFunc.put("setLeft", setLeft);
        this.allFunc.put("isAtom", isAtom);
        this.allFunc.put("isNil", isNil);
        this.allFunc.put("right", right);
        this.allFunc.put("left", left);
        this.allFunc.put("acq", acq);
        this.allFunc.put("rel", rel);
    }
}
