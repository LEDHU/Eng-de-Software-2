package br.unicap.nomedisciplina.atividade00.TestsAttack;

import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.DiceStrategy;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.DiceConfront;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.SpecificDice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestDiceConfront {
    SpecificDice sourceDiceOne;
    SpecificDice sourceDiceTwo;
    SpecificDice sourceDiceThree;
    SpecificDice destinationDiceOne;
    SpecificDice destinationDiceTwo;
    SpecificDice destinationDiceThree;

    @Test
    public void testDiceConfrontSourceVictory(){
        sourceDiceOne = new SpecificDice(6);
        sourceDiceTwo = new SpecificDice(5);

        destinationDiceOne = new SpecificDice(3);
        destinationDiceTwo = new SpecificDice(4);
        destinationDiceThree = new SpecificDice(5);


        int sourceNumberDice = 2;
        int destinationNumberDice = 3;

        ArrayList<DiceStrategy> sourceDiceList = new ArrayList<>();
        sourceDiceList.add(sourceDiceOne);
        sourceDiceList.add(sourceDiceTwo);

        ArrayList<DiceStrategy> destinationDiceList = new ArrayList<>();
        destinationDiceList.add(destinationDiceOne);
        destinationDiceList.add(destinationDiceTwo);
        destinationDiceList.add(destinationDiceThree);

        DiceConfront diceConfront = new DiceConfront(sourceNumberDice, destinationNumberDice, sourceDiceList, destinationDiceList);

        diceConfront.calculateLoss();

        int actualSourceLoss = diceConfront.getSourceLoss();
        int actualDestinationLoss = diceConfront.getDestinationLoss();
        int expectedSourceLoss = 0;
        int expectedDestinationLoss = 2;

        Assertions.assertEquals(expectedSourceLoss, actualSourceLoss);
        Assertions.assertEquals(expectedDestinationLoss, actualDestinationLoss);
    }

    @Test
    public void testDiceConfrontDestinationVictory(){
        int sourceNumberDice = 3;
        int destinationNumberDice = 3;

        sourceDiceOne = new SpecificDice(6);
        sourceDiceTwo = new SpecificDice(3);
        sourceDiceThree = new SpecificDice(3);
        destinationDiceOne = new SpecificDice(3);
        destinationDiceTwo = new SpecificDice(4);
        destinationDiceThree = new SpecificDice(6);

        ArrayList<DiceStrategy> sourceDiceList = new ArrayList<>();
        sourceDiceList.add(sourceDiceOne);
        sourceDiceList.add(sourceDiceTwo);
        sourceDiceList.add(sourceDiceThree);

        ArrayList<DiceStrategy> destinationDiceList = new ArrayList<>();
        destinationDiceList.add(destinationDiceOne);
        destinationDiceList.add(destinationDiceTwo);
        destinationDiceList.add(destinationDiceThree);

        DiceConfront diceConfront = new DiceConfront(sourceNumberDice, destinationNumberDice, sourceDiceList, destinationDiceList);

        diceConfront.calculateLoss();

        int actualSourceLoss = diceConfront.getSourceLoss();
        int actualDestinationLoss = diceConfront.getDestinationLoss();
        int expectedSourceLoss = 3;
        int expectedDestinationLoss = 0;

        Assertions.assertEquals(expectedSourceLoss, actualSourceLoss);
        Assertions.assertEquals(expectedDestinationLoss, actualDestinationLoss);
    }

    @Test
    public void testDiceConfrontTie(){
        int sourceNumberDice = 2;
        int destinationNumberDice = 2;

        sourceDiceOne = new SpecificDice(6);
        sourceDiceTwo = new SpecificDice(3);
        destinationDiceOne = new SpecificDice(3);
        destinationDiceTwo = new SpecificDice(4);

        ArrayList<DiceStrategy> sourceDiceList = new ArrayList<>();
        sourceDiceList.add(sourceDiceOne);
        sourceDiceList.add(sourceDiceTwo);

        ArrayList<DiceStrategy> destinationDiceList = new ArrayList<>();
        destinationDiceList.add(destinationDiceOne);
        destinationDiceList.add(destinationDiceTwo);

        DiceConfront diceConfront = new DiceConfront(sourceNumberDice, destinationNumberDice, sourceDiceList, destinationDiceList);

        diceConfront.calculateLoss();

        int actualSourceLoss = diceConfront.getSourceLoss();
        int actualDestinationLoss = diceConfront.getDestinationLoss();
        int expectedSourceLoss = 1;
        int expectedDestinationLoss = 1;

        Assertions.assertEquals(expectedSourceLoss, actualSourceLoss);
        Assertions.assertEquals(expectedDestinationLoss, actualDestinationLoss);

    }
}