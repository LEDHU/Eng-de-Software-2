package br.unicap.nomedisciplina.atividade00.calculations;

import br.unicap.nomedisciplina.atividade00.match.*;
import br.unicap.nomedisciplina.atividade00.match.Objective.*;

import java.util.LinkedList;

public class ObjetiveValidation {
    public boolean validationSameObjective(Player actualPlayer, Objective actualObj) {
        return actualPlayer.getObjPlayer().getId() - actualObj.getId() == 0;
    }

    public boolean validationSameTarget(Player actualPlayer, ObjectiveEliminateTarget actualObj) {
        return actualPlayer.getColor().equalsIgnoreCase(actualObj.getTargetColor());
    }

    public boolean validationTargetInMatch(LinkedList<Player> playes, Objective actualObj) {
        return playes.get(actualObj.getIdPlayer()).getObjPlayer().getId() < 6;
    }

    public boolean validationEliminatedTarget(LinkedList<Player> playes, ObjectiveEliminateTarget objective, Player player) {
        Player target = playes.get(objective.getIdTarget());
        if (target.getInMatch()) {
            return true;
        }
        return target.getLastDefendAgaints() == player.getId() && player.getLastAttackAgaints() == target.getId();
    }

    public boolean validationConquestConquestRequiredQuantity(LinkedList<Player> playes, ObjectiveConquestTerritoryNotSpecific actualObj) {
        Player player = playes.get(actualObj.getIdPlayer());
        return player.getTotalArmys() - actualObj.getQuantityConquered() == 0;
    }
}