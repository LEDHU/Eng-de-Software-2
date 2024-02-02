package br.unicap.nomedisciplina.atividade00.turn.attackPhase;

import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;

public class TerritoryConquest {
    private Territory source;
    private Territory destination;

    public TerritoryConquest(Territory source, Territory destination) {
        this.source = source;
        this.destination = destination;
    }


    public void conquest(int MaxSourceDices, int numOfArmies) throws WrongNumArmiesException {
        if(isValidNumOfArmies(numOfArmies, MaxSourceDices)) {

            destination.setPlayer(source.getPlayer());
        
            destination.setQtdArmies(numOfArmies);

            //Atualiza a quantidade de exercitos do source 
            source.setQtdArmies(MaxSourceDices - numOfArmies);

        }else {
            throw new WrongNumArmiesException("You can't move this amount of armies");
        }
    }

    public boolean isValidNumOfArmies(int numOfArmies, int MaxSourceDices) {
        if(numOfArmies > MaxSourceDices || numOfArmies < 1 || numOfArmies > 3) {
            return false;
        } else {
            return true;
        }
    }

}
