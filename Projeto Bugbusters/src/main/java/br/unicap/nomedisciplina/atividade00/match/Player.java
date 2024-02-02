package br.unicap.nomedisciplina.atividade00.match;

import br.unicap.nomedisciplina.atividade00.match.Objective.Objective;

public class Player {
    private final String color;
    private final int id;
    private int totalArmys;
    private Objective objPlayer;
    private boolean inMatch = true;
    private int lastAttackAgaints;
    private int lastDefendAgaints;


    public Player(String colorPlayer, int idPlayer, int armysPlayer) {
        this.color = colorPlayer;
        this.id = idPlayer;
        this.totalArmys = armysPlayer;
    }

    public Player(String colorPlayer, int id) {
        this.color = colorPlayer;
        this.id = id;
        this.totalArmys = 0;
    }

    public String getColor() {
        return this.color;
    }

    public int getTotalArmys() {
        return totalArmys;
    }

    public Objective getObjPlayer() {
        return this.objPlayer;
    }

    public boolean getInMatch() {
        return this.inMatch;
    }

    public int getId() {
        return id;
    }

    public int getLastAttackAgaints() {
        return this.lastAttackAgaints;
    }

    public int getLastDefendAgaints() {
        return lastDefendAgaints;
    }

    public void setTotalArmys(int changeTotalArmys) {
        this.totalArmys = changeTotalArmys;
    }

    public void setObjPlayer(Objective currentObj) {
        this.objPlayer = currentObj;
    }

    public void setInMatch(boolean playerLost) {
        this.inMatch = playerLost;
    }

    public void setLastAttackAgaints(int lastAttackAgaints) {
        this.lastAttackAgaints = lastAttackAgaints;
    }

    public void setLastDefendAgaints(int lastDefendAgaints) {
        this.lastDefendAgaints = lastDefendAgaints;
    }

    public String toString() {
        return "Id player: " + this.id  + "\n" + "Player color: " + this.color +
                "\n" + "Id objective: " + this.objPlayer.getId() +
                "\n" + "Description: " + this.objPlayer.getDescription() +
                "\n" + "Conquered territory " + this.totalArmys;
    }
}
