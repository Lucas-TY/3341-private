package ast;

import java.util.Map;

public abstract class Qtype {

    public abstract Long value(Map<String, Qtype> env);

    public abstract String toString();
}
