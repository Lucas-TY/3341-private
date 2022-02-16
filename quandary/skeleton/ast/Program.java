package ast;

import java.util.*;
import java.io.PrintStream;

public class Program extends ASTNode {
    /* new Program(arg,sl,loc(eleft,eright)); */
    final Map<String, Qtype> environment;
    final Stmt stmt;
    final String arg;
    final boolean empty;

    public Program(String arg, Stmt sl, Location loc) {
        super(loc);
        environment = new HashMap<String, Qtype>();
        this.arg = arg;
        this.stmt = sl;
        this.empty = false;
    }

    public Program(Location loc) {
        super(loc);
        this.empty = true;
        this.stmt = null;
        this.environment = null;
        this.arg = null;
    }

    public void println(PrintStream ps) {
        ps.println(stmt);
    }

    public Qtype exec(long argument) {
        Qval value = new Qval(argument);
        if (this.empty == true) {
            return null;
        }

        environment.put(arg, value);
        return this.stmt.execute(environment);
    }
}
