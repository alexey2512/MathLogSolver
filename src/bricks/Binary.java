package bricks;

public abstract class Binary implements Expression {

    public final Expression left;
    public final Expression right;

    public Binary(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract String sign();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        fastToString(sb, false);
        return sb.toString();
    }

    @Override
    public void fastToString(StringBuilder sb, boolean withBraces) {
        if (withBraces) {
            sb.append('(');
        }
        left.fastToString(sb,
                this.getClass() == Implication.class ?
                priority() == left.priority() :
                left.priority() < priority());
        sb.append(" ").append(sign()).append(" ");
        right.fastToString(sb,
                this.getClass() != Implication.class &&
                        right.priority() < priority());
        if (withBraces) {
            sb.append(')');
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() &&
                ((Binary) obj).left.equals(left) &&
                ((Binary) obj).right.equals(right);
    }
}
