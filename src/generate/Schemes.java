package generate;

import bricks.*;

import java.util.*;

public class Schemes {

    public static final List<Scheme> schemes = List.of(
            expressions -> new Implication(
                    expressions[0],
                    new Implication(
                            expressions[1],
                            expressions[0]
                    )
            ),

            expressions -> new Implication(
                    new Implication(
                            expressions[0],
                            expressions[1]
                    ),
                    new Implication(
                            new Implication(
                                    expressions[0],
                                    new Implication(
                                            expressions[1],
                                            expressions[2]
                                    )
                            ),
                            new Implication(
                                    expressions[0],
                                    expressions[2]
                            )
                    )
            ),

            expressions -> new Implication(
                    new Conjunction(
                            expressions[0],
                            expressions[1]
                    ),
                    expressions[0]
            ),

            expressions -> new Implication(
                    new Conjunction(
                            expressions[0],
                            expressions[1]
                    ),
                    expressions[1]
            ),

            expressions -> new Implication(
                    expressions[0],
                    new Implication(
                            expressions[1],
                            new Conjunction(
                                    expressions[0],
                                    expressions[1]
                            )
                    )
            ),

            expressions -> new Implication(
                    expressions[0],
                    new Disjunction(
                            expressions[0],
                            expressions[1]
                    )
            ),

            expressions -> new Implication(
                    expressions[1],
                    new Disjunction(
                            expressions[0],
                            expressions[1]
                    )
            ),

            expressions -> new Implication(
                    new Implication(
                            expressions[0],
                            expressions[2]
                    ),
                    new Implication(
                            new Implication(
                                    expressions[1],
                                    expressions[2]
                            ),
                            new Implication(
                                    new Disjunction(
                                            expressions[0],
                                            expressions[1]
                                    ),
                                    expressions[2]
                            )
                    )
            ),

            expressions -> new Implication(
                    new Implication(
                            expressions[0],
                            expressions[1]
                    ),
                    new Implication(
                            new Implication(
                                    expressions[0],
                                    new Negate(expressions[1])
                            ),
                            new Negate(expressions[0])
                    )
            ),

            expressions -> new Implication(
                    new Negate(new Negate(expressions[0])),
                    expressions[0]
            )
    );



}
