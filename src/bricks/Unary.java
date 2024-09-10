package bricks;

public abstract class Unary implements Expression {

    public final Expression expr;

    public Unary(Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        fastToString(sb, false);
        return sb.toString();
    }

    protected abstract String sign();

    @Override
    public void fastToString(StringBuilder sb, boolean withBraces) {
        if (withBraces) {
            sb.append('(');
        }
        sb.append(sign());
        expr.fastToString(sb, expr.priority() < priority());
        if (withBraces) {
            sb.append(')');
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() && ((Unary) obj).expr.equals(expr);
    }

}
