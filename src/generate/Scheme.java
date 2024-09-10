package generate;

import bricks.Expression;

@FunctionalInterface
public interface Scheme {
    Expression build(Expression... expressions);
}
