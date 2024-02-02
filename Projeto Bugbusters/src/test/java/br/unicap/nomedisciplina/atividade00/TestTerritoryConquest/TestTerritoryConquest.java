package br.unicap.nomedisciplina.atividade00.TestTerritoryConquest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.unicap.nomedisciplina.atividade00.match.*;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.TerritoryConquest;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;


public class TestTerritoryConquest {
    private Territory source;
    private Territory destination;
    private Player playerSource;
    private Player playerDestination;
    private TerritoryConquest territoryConquest;

    @BeforeEach
    void setUp() {
        this.playerSource = new Player("red", 1);
        this.playerDestination = new Player("blue", 2);
        this.source = new Territory("India", playerSource);
        this.destination = new Territory("China", playerDestination);
        this.territoryConquest = new TerritoryConquest(source, destination);
    }

    @Test
    void testWonConfrontDiceAndConqueredTerritory() throws WrongNumArmiesException {
        int numOfArmies = 3;
        int MaxSourceDices = 5;
        territoryConquest.conquest(MaxSourceDices, numOfArmies);
        Player expected = source.getPlayer();
        Player actual = destination.getPlayer();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testDestinationIsReceivingTheCorrenctNumOfArmies() throws WrongNumArmiesException {
        int numOfArmies = 1;
        int MaxSourceDices = 3;
        territoryConquest.conquest(MaxSourceDices, numOfArmies);
        int expected = numOfArmies;
        int actual = destination.getQtdArmies();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSourceIsLoosingTheArmiesThatConqueredDestination() throws WrongNumArmiesException {
        int numOfArmies = 2;
        int MaxSourceDices = 4;
        territoryConquest.conquest(MaxSourceDices, numOfArmies);
        int expected = MaxSourceDices - numOfArmies;
        int actual = source.getQtdArmies();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPlayerTryToPassMoreThanThreeArmies() {
        try {

            territoryConquest.conquest(3, 5);

        } catch (WrongNumArmiesException e) {

            Assertions.assertEquals("You can't move this amount of armies", e.getMessage());
        }
    }

}
