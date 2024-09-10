package bricks;

public interface Expression {
    int priority();
    void fastToString(StringBuilder sb, boolean withBraces);
}
