package br.unicap.nomedisciplina.atividade00.turn.attackPhase.battle;

import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.TerritoryConquest;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice.DiceConfront;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.PlayerIsEqualException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceIsntAdjacentException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceNotHasArmysEnoughException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;

import java.util.Objects;

public class Battle {
    private final Territory source;
    private final Territory destination;
    private int maxSourceDices;
    private int maxDestinationDices;
    private final TerritoryConquest newConquest;

    public Battle(Territory source, Territory destination) {
        this.source = source;
        this.destination = destination;
        this.maxSourceDices = 0;
        this.maxDestinationDices = 0;
        this.newConquest = new TerritoryConquest(source, destination);
    }

    private void updateNum(int sourceLoss, int destinationLoss) {
        //altera a quantidade do soldados no territorio de ataque e defesa
        source.setQtdArmies(source.getQtdArmies() - sourceLoss);
        destination.setQtdArmies(destination.getQtdArmies() - destinationLoss);

        //altera a quantidade do soldados totais dos jogadores de ataque e defesa
        source.getPlayer().setTotalArmys(source.getPlayer().getTotalArmys() - sourceLoss);
        destination.getPlayer().setTotalArmys(destination.getPlayer().getTotalArmys() - destinationLoss);
    }

    public void startBattle() throws SourceNotHasArmysEnoughException, PlayerIsEqualException, SourceIsntAdjacentException, WrongNumArmiesException {
        if (isTerritoriesAdjacent(source, destination)) {
            if (!Objects.equals(source.getPlayer().getId(), destination.getPlayer().getId())) {
                verificationSource();
                calcuteMaxNum();
                DiceConfront diceConfront = new DiceConfront(getMaxSourceDices(), getMaxDestinationDices());

                int sourceLoss = diceConfront.getSourceLoss();
                int destinationLoss = diceConfront.getDestinationLoss();
                updateNum(sourceLoss, destinationLoss);
                if (destination.getQtdArmies() == 0) {
                    newConquest.conquest(this.maxSourceDices, 1);
                    destination.setPlayer(source.getPlayer());
                } else {
                    throw new PlayerIsEqualException("You cannot attack your territory");
                }
            } else {
                throw new SourceIsntAdjacentException("Source is not adjacent to destination");
            }
        }
    }

    public boolean isTerritoriesAdjacent(Territory source, Territory destination) {
        return source.getAdjacentTerritories().contains(destination);
    }

    private void verificationSource() throws SourceNotHasArmysEnoughException {
        if(this.source.getQtdArmies() <= 1) throw new SourceNotHasArmysEnoughException("Source doesn't have enough armys");
    }

    private void calcuteMaxNum(){
        this.maxSourceDices = Math.min(this.source.getQtdArmies() - 1, 3);
        this.maxDestinationDices = Math.min(this.destination.getQtdArmies(), 3);
    }

    public int getMaxSourceDices() {
        return maxSourceDices;
    }

    public int getMaxDestinationDices() {
        return maxDestinationDices;
    }

}