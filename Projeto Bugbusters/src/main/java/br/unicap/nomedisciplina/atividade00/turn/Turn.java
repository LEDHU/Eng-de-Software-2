package br.unicap.nomedisciplina.atividade00.turn;

import br.unicap.nomedisciplina.atividade00.turn.attackPhase.AttackPhase;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.PlayerIsEqualException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceIsntAdjacentException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceNotHasArmysEnoughException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;
import br.unicap.nomedisciplina.atividade00.match.Player;
import br.unicap.nomedisciplina.atividade00.match.Territory;

import java.util.ArrayList;

public class Turn {
    private Player currentPlayer;
    private final ArrayList<Player> players;

    public Turn(ArrayList<Player> players) {
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public void nextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        currentPlayer = players.get(nextIndex);
    }

    // Gabriel
    public void reinforcementPhase(Territory source, Territory destination, int qtdArmies) {

        // Verifica se o jogador é dono dos territórios de origem e destino.
        if (currentPlayer.equals(source.getPlayer()) && currentPlayer.equals(destination.getPlayer())) {

            // Verifica se o número de tropas é válido e se o jogador tem tropas
            // disponíveis.
            if (qtdArmies > 0 && source.getQtdArmies() >= qtdArmies) {

                // Realocação/fortificação das tropas.
                source.removeArmies(qtdArmies);
                destination.addArmies(qtdArmies);

                // Avança para a vez do próximo jogador.
                nextPlayer();
            } else {
                // Tratar quantidade de tropas inválida ou falta de tropas disponíveis
                System.out.println("Invalid or insufficient number of troops for redeployment.");
            }
        } else {
            // Tratar erro, o jogador não é dono dos territórios
            System.out.println(
                    "You do not own one of the selected territories and cannot perform relocation/fortification");
        }
    }

    public void attackPhase(Territory source, Territory destination)
            throws SourceIsntAdjacentException, SourceNotHasArmysEnoughException, PlayerIsEqualException, WrongNumArmiesException {
        AttackPhase attackPhase = new AttackPhase(source, destination);
        attackPhase.attack();
    }

    // gabriel
    public void movementPhase(Territory source, Territory destination, int qtdArmies) {

        if (currentPlayer.equals(source.getPlayer()) && currentPlayer.equals(destination.getPlayer())) {
            if (qtdArmies > 0 && source.getQtdArmies() - qtdArmies >= 1) {

                source.removeArmies(qtdArmies);
                destination.addArmies(qtdArmies);

                nextPlayer();
            } else {
                // Tratar quantidade de tropas inválida ou falta de tropas suficientes em origem
                System.out.println("Invalid or insufficient number of troops for redeployment.");
            }
        } else {
            // Tratar erro, o jogador não é dono dos territórios
            System.out.println(
                    "You do not own one of the selected territories and cannot perform relocation/fortification");
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
