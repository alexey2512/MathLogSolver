package generate;

import bricks.*;

import java.util.*;

public class Generator {

    private static final Random rand = new Random();
    private static final List<String> variables = List.of("A", "B");

    private Generator() {}

    public static Expression randomGenerate(int maxDepth) {
        if (maxDepth <= 0) {
            return new Variable(variables.get(rand.nextInt(variables.size())));
        }
        int x = rand.nextInt(5);
        return switch (x) {
            case 0 -> new Variable(variables.get(rand.nextInt(variables.size())));
            case 1 -> new Negate(randomGenerate(maxDepth - 1));
            case 2 -> new Implication(randomGenerate(maxDepth - 1), randomGenerate(maxDepth - 1));
            case 3 -> new Conjunction(randomGenerate(maxDepth - 1), randomGenerate(maxDepth - 1));
            case 4 -> new Disjunction(randomGenerate(maxDepth - 1), randomGenerate(maxDepth - 1));
            default -> null;
        };
    }

    public static Expression buildByScheme(int index, Expression... expressions) {
        return Schemes.schemes.get(index).build(expressions);
    }

}
