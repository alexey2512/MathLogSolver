import java.util.*;
import bricks.*;
import generate.*;
import logs.*;
import logs.Scheme;


public class Main {

    static int outIndex;

    public static void filter(int curIndex, List<Log> logs, Map<Integer, Integer> indexMap) {
        if (logs.get(curIndex).getClass() == ModusPonens.class) {
            ModusPonens log = (ModusPonens) logs.get(curIndex);
            filter(log.getSrc(), logs, indexMap);
            filter(log.getImp(), logs, indexMap);
        }
        if (!indexMap.containsKey(curIndex)) {
            indexMap.put(curIndex, outIndex);
            outIndex++;
        }
    }

    public static void main(String[] args) {
        Expression target = new Implication(
                new Variable("A"),
                new Negate(new Negate(new Variable("A")))
        );
        List<Expression> proof = new ArrayList<>();
        List<Log> logs = new ArrayList<>();
        int schemeIndex = 0;
        outer: while (true) {
            int maxDepth = 2;
            Expression[] expressions = {
                    Generator.randomGenerate(maxDepth),
                    Generator.randomGenerate(maxDepth),
                    Generator.randomGenerate(maxDepth)
            };
            Expression result = Generator.buildByScheme(schemeIndex, expressions);
            proof.add(result);
            logs.add(new Scheme(schemeIndex, expressions));
            schemeIndex = (schemeIndex + 1) % 10;
            if (proof.getLast().equals(target))
                break;
            int lastIndex = proof.size() - 1;
            while (lastIndex < proof.size()) {
                Expression last = proof.get(lastIndex);
                for (int i = 0; i < lastIndex; i++) {
                    if (last.getClass() == Implication.class &&
                            ((Binary) last).left.equals(proof.get(i))) {
                        proof.add(((Binary) last).right);
                        logs.add(new ModusPonens(i, lastIndex));
                        if (proof.getLast().equals(target))
                            break outer;
                    }
                }
                lastIndex++;
            }

        }
        outIndex = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        filter(proof.size() - 1, logs, indexMap);
        System.out.println("$\\spt\\spt\\spo\\vdash " + target + "$\n");
        System.out.println("$\\spo$\n");
        for (int i = 0; i < proof.size(); i++) {
            if (indexMap.containsKey(i)) {
                Expression e = proof.get(i);
                Log log = logs.get(i);
                if (log.getClass() == ModusPonens.class) {
                    ModusPonens mp = (ModusPonens) log;
                    mp.setSrc(indexMap.get(mp.getSrc()));
                    mp.setImp(indexMap.get(mp.getImp()));
                }
                int newIndex = indexMap.get(i);
                System.out.println((newIndex + 1) + ". $" + e + "$ " + log.getLog() + "\n");
            }
        }
    }
}