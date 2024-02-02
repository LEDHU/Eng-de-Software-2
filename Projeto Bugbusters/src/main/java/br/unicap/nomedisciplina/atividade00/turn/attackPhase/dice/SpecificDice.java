package br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice;

public class SpecificDice implements DiceStrategy {
    private final Integer value;

    public SpecificDice(Integer value) {
        this.value = value;
    }

    @Override
    public Integer roll() {
        return value;
    }

    public Integer getValue() {
        return value;
    }
}
