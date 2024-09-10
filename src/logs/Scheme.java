package logs;

import bricks.*;
import java.util.List;

public class Scheme implements Log {

    private static final List<String> letters = List.of("\\alpha", "\\beta", "\\gamma");
    private static final int[] varCounts = {2, 3, 2, 2, 2, 2, 2, 3, 2, 1};

    private final int schemeIndex;
    private final Expression[] args;

    public Scheme(int schemeIndex, Expression... args) {
        this.schemeIndex = schemeIndex;
        this.args = args;
    }

    @Override
    public String getLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("(sch. $").append(schemeIndex + 1);
        for (int i = 0; i < varCounts[schemeIndex]; i++) {
            sb.append(",\\spt").append(letters.get(i)).append(" := ").append(args[i]);
        }
        sb.append("$)");
        return sb.toString();
    }

}
