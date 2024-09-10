package bricks;

import java.util.*;

public class Disjunction extends Binary {

    public Disjunction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int priority() {
        return 100;
    }

    @Override
    protected String sign() {
        return "\\vee";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        List<Expression> list = new ArrayList<>();
        add(this, list);
        List<Expression> other = new ArrayList<>();
        add((Expression) obj, other);
        return list.equals(other);
    }

    private void add(Expression expr, List<Expression> list) {
        if (expr.getClass() != Disjunction.class) {
            list.add(expr);
            return;
        }
        add(((Binary) expr).left, list);
        add(((Binary) expr).right, list);
    }

}
