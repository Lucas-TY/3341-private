package ast;

import java.util.Map;

public class ConcurBinaryExpr extends Expr {
    Map<String, Qtype> env;
    final Expr expr1;
    final Expr expr2;
    final int operator;

    public ConcurBinaryExpr(BinaryExpr e, Location loc) {
        super(loc);
        this.expr1 = e.expr1;
        this.expr2 = e.expr2;
        this.operator = e.operator;
    }

    @Override
    public Qtype eval(Map<String, Function> allFunc, Map<String, Qtype> env) {
        RunnableExpr runnable1 = new RunnableExpr(this.expr1, allFunc, env);
        RunnableExpr runnable2 = new RunnableExpr(this.expr2, allFunc, env);
        Thread runningExpr1 = new Thread(runnable1);
        Thread runningExpr2 = new Thread(runnable2);
        runningExpr1.start();
        runningExpr2.start();
        try {
            runningExpr1.join();
            runningExpr2.join();
        } catch (InterruptedException e) {
            System.out.println("Concurrent Thread interrupted in main.");
            e.printStackTrace();
        }
        if (this.operator != 4) {
            Qval result1 = (Qval)runnable1.result;
            Qval result2 = (Qval)runnable2.result;
            ConstExpr left = new ConstExpr(result1.value(), loc);
            ConstExpr right = new ConstExpr(result2.value(), loc);
            return new BinaryExpr(left, operator, right, loc).eval(allFunc, env);
        } else {
            Qtype result1 = runnable1.result;
            Qtype result2 = runnable2.result;
            return new Qref(result1, result2);
        }
        

    }

    class RunnableExpr implements Runnable {
        final private Expr expr;
        public boolean done = false;
        public Qtype result;
        private Map<String, Function> allFunc;
        private Map<String, Qtype> env;

        RunnableExpr(Expr expr, Map<String, Function> allFunc, Map<String, Qtype> env) {
            this.expr = expr;
            this.allFunc = allFunc;
            this.env = env;
        }

        public void run() {
            System.out.println("Running Concurrently");
            try {
                this.result = (Qtype) this.expr.eval(this.allFunc, this.env);
                this.done = true;
            } catch (Exception e) {
                System.out.println("Concurrent Thread interrupted.");
                e.printStackTrace();
            }
            System.out.println("Concurrent Thread exiting.");
        }

    }
}