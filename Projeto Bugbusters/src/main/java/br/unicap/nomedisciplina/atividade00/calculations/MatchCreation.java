package br.unicap.nomedisciplina.atividade00.calculations;

import br.unicap.nomedisciplina.atividade00.match.*;
import br.unicap.nomedisciplina.atividade00.match.Objective.*;

import java.util.LinkedList;
import java.util.Random;

public class MatchCreation {
    private final StartingAttributes attributes;
    private final Random random;
    private int qntPlayer;

    public MatchCreation() {
        this.attributes = new StartingAttributes();
        this.random = new Random();
    }

    private void creationEarlyArmys() {
        int qntTerritory = this.attributes.getTotalTerritory();
        this.qntPlayer = random.nextInt(4) + 3;
        this.attributes.setEarlyArmys(qntTerritory / qntPlayer);
    }

    public void creationPlayer(LinkedList<Player> playes) {
        Player player;
        this.creationEarlyArmys();
        for (int i = 0; i <= qntPlayer - 1; i++) {
            player = new Player(this.attributes.getColor()[i], i, this.attributes.getEarlyArmys());
            playes.add(player);
        }
    }

    public void creationObjectiveTargetInMatch(LinkedList<Player> playes, ObjectiveEliminateTarget objective) {
        Objective newObjective;
        int size, i;
        size = playes.size();
        for (i = 0; i <= size - 1; i++) {
            if (playes.get(i).getColor().equals(objective.getTargetColor()) && playes.get(i).getTotalArmys() > 0) {
                objective.setIdTarget(playes.get(i).getId());
                playes.get(objective.getIdPlayer()).setObjPlayer(objective);
                return;
            }
        }
        newObjective = new ObjectiveConquestTerritoryNotSpecific(6, objective.getDescription(), objective.getIdPlayer());
        playes.get(objective.getIdPlayer()).setObjPlayer(newObjective);
    }

    public void afterSuccessfulConfrontation(LinkedList<Player> playes, ObjectiveEliminateTarget objective, int idPlayer, int lostArmys) {
        int idTarget = objective.getIdTarget();
        int actualArmys = playes.get(idTarget).getTotalArmys() - lostArmys;
        playes.get(idTarget).setTotalArmys(actualArmys);
        if (actualArmys == 0) {
            playes.get(idTarget).setInMatch(false);
        }
        playes.get(idTarget).setLastDefendAgaints(idPlayer);
        playes.get(idPlayer).setLastAttackAgaints(idTarget);
    }
}