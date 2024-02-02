package br.unicap.nomedisciplina.atividade00.TestsAttack;

import br.unicap.nomedisciplina.atividade00.match.Player;
import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.AttackPhase;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.battle.Battle;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.PlayerIsEqualException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceIsntAdjacentException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceNotHasArmysEnoughException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBattle {
    private Territory source;
    private Territory destination;
    AttackPhase attackPhase;

    @BeforeEach
    void setUp(){
        Player PSource = new Player("Blue", 1);
        Player PDesti = new Player("Red", 2);
        this.source = new Territory("Brazil", PSource);
        this.destination = new Territory("Chile", PDesti);
        this.attackPhase = new AttackPhase(source, destination);
    }

    @Test
    public void testMaxDicesRolled() {
        setUp();

        int sourceNum = 15;
        int destinationNum = 3;

        source.setQtdArmies(sourceNum);
        destination.setQtdArmies(destinationNum);

        source.addAdjacentTerritory(destination);

        Battle battle = new Battle(source, destination);

        try {
            battle.startBattle();

            int actualMaxSourceDices = battle.getMaxSourceDices();
            int actualMaxDestinationDices = battle.getMaxDestinationDices();
            int expectedMaxSourceDices = 3;
            int expectedMaxDestinationDices = 3;

            int actualMaxDices = actualMaxSourceDices + actualMaxDestinationDices;
            int expectedMaxDices = expectedMaxSourceDices + expectedMaxDestinationDices;

            Assertions.assertEquals(actualMaxDices, expectedMaxDices);
        } catch (SourceNotHasArmysEnoughException e) {
            Assertions.assertEquals("Source doesn't have enough armys", e.getMessage());
        } catch (WrongNumArmiesException | SourceIsntAdjacentException | PlayerIsEqualException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMinDicesRolled() {
        setUp();

        int sourceNum = 2;
        int destinationNum = 1;

        source.setQtdArmies(sourceNum);
        destination.setQtdArmies(destinationNum);

        source.addAdjacentTerritory(destination);

        Battle battle = new Battle(source, destination);

        try {
            battle.startBattle();

            int actualMaxSourceDices = battle.getMaxSourceDices();
            int actualMaxDestinationDices = battle.getMaxDestinationDices();
            int expectedMaxSourceDices = 1;
            int expectedMaxDestinationDices = 1;

            int actualMaxDices = actualMaxSourceDices + actualMaxDestinationDices;
            int expectedMaxDices = expectedMaxSourceDices + expectedMaxDestinationDices;

            Assertions.assertEquals(actualMaxDices, expectedMaxDices);
        }
        catch (SourceNotHasArmysEnoughException e) {
            Assertions.assertEquals("Source doesn't have enough armys", e.getMessage());
        } catch (WrongNumArmiesException | SourceIsntAdjacentException | PlayerIsEqualException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMiddleDicesRolled() {
        setUp();

        int sourceNum = 3;
        int destinationNum = 1;

        source.setQtdArmies(sourceNum);
        destination.setQtdArmies(destinationNum);

        source.addAdjacentTerritory(destination);

        Battle battle = new Battle(source, destination);

        try {
            battle.startBattle();

            int actualMaxSourceDices = battle.getMaxSourceDices();
            int actualMaxDestinationDices = battle.getMaxDestinationDices();
            int expectedMaxSourceDices = 2;
            int expectedMaxDestinationDices = 1;

            int actualMaxDices = actualMaxSourceDices + actualMaxDestinationDices;
            int expectedMaxDices = expectedMaxSourceDices + expectedMaxDestinationDices;

            Assertions.assertEquals(actualMaxDices, expectedMaxDices);
        } catch (SourceNotHasArmysEnoughException e) {
            Assertions.assertEquals("Source doesn't have enough armys", e.getMessage());
        } catch (WrongNumArmiesException | SourceIsntAdjacentException | PlayerIsEqualException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSourceCanNotAttackException() {
        setUp();

        int sourceNum = 1;
        int destinationNum = 29;

        source.setQtdArmies(sourceNum);
        destination.setQtdArmies(destinationNum);

        Battle battle = new Battle(source, destination);
        try {
            battle.startBattle();
        } catch (SourceNotHasArmysEnoughException | PlayerIsEqualException | SourceIsntAdjacentException | WrongNumArmiesException e) {
            Assertions.assertEquals("Source doesn't have enough armys", e.getMessage());
        }
    }

    @Test
    void testIsntAdjacentTerritory() {
        setUp();

        try {
            attackPhase.attack();
        }
        catch (SourceIsntAdjacentException | SourceNotHasArmysEnoughException | PlayerIsEqualException | WrongNumArmiesException e) {
            Assertions.assertEquals("Source is not adjacent to destination", e.getMessage());
        }
    }

    @Test
    void testCannotAttackYourTerritory() {
        setUp();

        source.setQtdArmies(8);
        destination.setQtdArmies(5);

        source.addAdjacentTerritory(destination);
        destination.addAdjacentTerritory(source);

        try {
            attackPhase.attack();
        }
        catch (SourceIsntAdjacentException | SourceNotHasArmysEnoughException | PlayerIsEqualException | WrongNumArmiesException e) {
            Assertions.assertEquals("You cannot attack your territory", e.getMessage());
        }
    }
}