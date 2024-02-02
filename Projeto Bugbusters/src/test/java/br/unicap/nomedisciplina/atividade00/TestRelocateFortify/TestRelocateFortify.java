package br.unicap.nomedisciplina.atividade00.TestRelocateFortify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicap.nomedisciplina.atividade00.match.Player;
import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.Turn;

public class TestRelocateFortify {

    private Territory source;
    private Territory destination;
    private Player player1;
    private Player player2;
    private Player player3;
    private ArrayList<Player> playeres;
    private Turn turn;

    @BeforeEach
    void setUp() {
        player1 = new Player("Blue", 1, 10);
        player2 = new Player("Red", 2, 11);
        player3 = new Player("Black", 3, 6);

        playeres = new ArrayList<>();
        playeres.add(player1);
        playeres.add(player2);
        playeres.add(player3);
        
        source = new Territory("SourceTerritory", player1);
        destination = new Territory("DestinationTerritory", player1);
        turn = new Turn(playeres); 
    }

    @Test
    void testReinforcementPhase() {
        // Teste de reforço válido
        turn.reinforcementPhase(source, destination, 5);
        assertEquals(source.getQtdArmies(), 5); // Verifica se a origem perdeu 5 exércitos.
        assertEquals(destination.getQtdArmies(), 15); // Verifica se o destino ganhou 5 exércitos.

        // Teste de reforço inválido (quantidade de tropas negativa)
        turn.reinforcementPhase(source, destination, -1);
        assertEquals(source.getQtdArmies(), 5); // A quantidade de tropas não deve mudar.

        // Teste de reforço inválido (origem e destino de propriedade de jogadores
        // diferentes)
        Territory otherPlayerTerritory = new Territory("OtherPlayerTerritory", new Player("Player2", 2, 5));
        turn.reinforcementPhase(source, otherPlayerTerritory, 3);
        assertEquals(source.getQtdArmies(), 5); // A quantidade de tropas não deve mudar.
    }

    @Test
    void testMovementPhase() {
        // Teste de movimento válido
        turn.movementPhase(source, destination, 3);
        assertEquals(source.getQtdArmies(), 7); // Verifica se a origem perdeu 3 exércitos.
        assertEquals(destination.getQtdArmies(), 13); // Verifica se o destino ganhou 3 exércitos.

        // Teste de movimento inválido (quantidade de tropas negativa)
        turn.movementPhase(source, destination, -1);
        assertEquals(source.getQtdArmies(), 7); // A quantidade de tropas não deve mudar.

        // Teste de movimento inválido (não há tropas suficientes na origem)
        turn.movementPhase(source, destination, 10);
        assertEquals(source.getQtdArmies(), 7); // A quantidade de tropas não deve mudar.
    }
}