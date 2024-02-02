package br.unicap.nomedisciplina.atividade00.TestTurn;

import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.PlayerIsEqualException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceIsntAdjacentException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceNotHasArmysEnoughException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;
import br.unicap.nomedisciplina.atividade00.match.Player;
import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.Turn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurn {
    Territory source;
    Territory destination;

    ArrayList<Player> playeres;

    Player player1;
    Player player2;
    Player player3;

    Turn turn;

    void setUp(){
        player1 = new Player("Blue", 1, 5);
        player2 = new Player("Red", 2, 4);
        player3 = new Player("Black", 3, 6);

        playeres = new ArrayList<>();

        source = new Territory("Brasil", player1);
        destination = new Territory("Peru", player1);
    }

    @Test
    public void testTurnCurrentPlayer(){
        setUp();

        playeres.add(player1);
        playeres.add(player2);
        playeres.add(player3);

        turn = new Turn(playeres);
        turn.nextPlayer();

        System.out.println(turn.getPlayers().size());

        assertEquals(turn.getCurrentPlayer(), player2);
    }

    @Test
    public void testTurnAttackThrowException() {
        setUp();

        playeres.add(player1);
        playeres.add(player2);
        playeres.add(player3);

        turn = new Turn(playeres);

        try {
            turn.attackPhase(source, destination);
        }
        catch (SourceIsntAdjacentException | SourceNotHasArmysEnoughException | PlayerIsEqualException | WrongNumArmiesException e) {
            Assertions.assertEquals("Source is not adjacent to destination", e.getMessage());
        }
    }

    @Test
    public void testTurnAttackGetLosses(){
        setUp();

        source.setQtdArmies(5);
        destination.setQtdArmies(4);

        playeres.add(player1);
        playeres.add(player2);
        playeres.add(player3);

        turn = new Turn(playeres);

        try {
            int olderActual = player1.getTotalArmys() + player2.getTotalArmys();
            turn.attackPhase(source, destination);
            int actual = (player1.getTotalArmys() + player2.getTotalArmys()) - olderActual ;
            int expected = 3;
            Assertions.assertEquals(actual, expected);
        }
        catch (SourceIsntAdjacentException | SourceNotHasArmysEnoughException | PlayerIsEqualException | WrongNumArmiesException e) {
            Assertions.assertEquals("Source is not adjacent to destination", e.getMessage());
        }
    }
}