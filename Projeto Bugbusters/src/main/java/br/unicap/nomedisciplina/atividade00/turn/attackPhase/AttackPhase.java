package br.unicap.nomedisciplina.atividade00.turn.attackPhase;

import br.unicap.nomedisciplina.atividade00.match.Territory;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.battle.Battle;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.PlayerIsEqualException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceIsntAdjacentException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.SourceNotHasArmysEnoughException;
import br.unicap.nomedisciplina.atividade00.turn.attackPhase.exceptions.WrongNumArmiesException;

public class AttackPhase {
    private final Battle battle;

    public AttackPhase(Territory source, Territory destination) {
        this.battle = new Battle(source, destination);
    }

    public void attack() throws SourceNotHasArmysEnoughException, SourceIsntAdjacentException, PlayerIsEqualException, WrongNumArmiesException {
        battle.startBattle();
    }
}
