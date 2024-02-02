package br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice;

import java.util.Random;

public class RandomDice implements DiceStrategy {
    private Integer value;

    public RandomDice() {
        roll();
    }

    @Override
    public Integer roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
        return this.value;
    }

    public Integer getValue() {
        return value;
    }

}

