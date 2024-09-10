package bricks;

public class Negate extends Unary {

    public Negate(Expression expr) {
        super(expr);
    }

    @Override
    public int priority() {
        return 300;
    }

    @Override
    protected String sign() {
        return "\\neg";
    }

}
