package br.unicap.nomedisciplina.atividade00.TestsAttack;

import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.DiceStrategy;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.RandomDice;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.SpecificDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDice {
    @Test
    public void testRollRandomDice() {
        RandomDice randomDice = new RandomDice();
        int result = randomDice.getValue();
        assertTrue(result >= 1 && result <= 6);
    }

    @Test
    public void testRollSpecificDice() {
        SpecificDice specificDice = new SpecificDice(4);
        int result = specificDice.getValue();
        assertEquals(4, result);
    }

}