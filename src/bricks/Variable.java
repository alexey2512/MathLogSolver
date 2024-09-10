package bricks;

public class Variable implements Expression {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int priority() {
        return 400;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void fastToString(StringBuilder sb, boolean withBraces) {
        sb.append(name);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && ((Variable) obj).name.equals(name);
    }
}
