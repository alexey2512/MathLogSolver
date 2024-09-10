package logs;

public class ModusPonens implements Log {

    private int src;
    private int imp;

    public ModusPonens(int src, int imp) {
        this.src = src;
        this.imp = imp;
    }

    @Override
    public String getLog() {
        return "(M.P. " + (src + 1) + ", " + (imp + 1) + ")";
    }

    public int getSrc() {
        return src;
    }

    public int getImp() {
        return imp;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }
}
