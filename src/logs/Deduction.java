package logs;

public class Deduction implements Log {

    private int left, right;

    public Deduction(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public String getLog() {
        return "(D.R. " + (left + 1) + ", " + (right + 1) + ")";
    }
}
