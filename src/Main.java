import bricks.*;
import generate.*;
import logs.State;

import java.util.*;

public class Main {

    public static void filter(int index, List<State> states, List<Integer> indexes) {
        indexes.add(index);
        State state = states.get(index);
        if (state == State.MODUS_PONENS) {
            filter(state.getCom(), states, indexes);
            filter(state.getImp(), states, indexes);
        }
    }


    public static void main(String[] args) {
        Expression target = new Implication(
                new Variable("A"),
                new Variable("A")
        );
        List<Expression> proof = new ArrayList<>();
        List<State> states = new ArrayList<>();
        outer: do {
            for (int k = 0; k < 10; k++) {
                Expression[] exs = new Expression[]{
                        Generator.randomGenerate(2),
                        Generator.randomGenerate(2),
                        Generator.randomGenerate(2)
                };
                Expression result = Generator.buildByScheme(k, exs);
                proof.add(result);
                State stateSCH = State.SCHEME;
                stateSCH.setData(k, exs);
                states.add(stateSCH);
                if (proof.getLast().equals(target)) {
                    break outer;
                }
                int size = proof.size();
                for (int i = 0; i < size; i++) {
                    int j = proof.size() - 1;
                    if (proof.get(j).getClass() == Implication.class && proof.get(i).equals(((Binary) proof.get(j)).left)) {
                        proof.add(((Binary) proof.get(j)).right);
                        State stateMP = State.MODUS_PONENS;
                        stateMP.setData(i, j);
                        states.add(stateMP);
                        if (proof.getLast().equals(target)) {
                            break outer;
                        }
                    }
                }
            }
        } while (true);

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < proof.size(); i++) {
            System.out.println((i + 1) + ". " + proof.get(i) + " " + states.get(i).getLog());
        }
    }
}