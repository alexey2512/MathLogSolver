package bricks;

public class Implication extends Binary {

    public Implication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    protected String sign() {
        return "\\rightarrow";
    }

}
