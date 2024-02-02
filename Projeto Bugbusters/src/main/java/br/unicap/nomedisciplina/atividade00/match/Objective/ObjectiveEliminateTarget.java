package br.unicap.nomedisciplina.atividade00.match.Objective;

public class ObjectiveEliminateTarget implements Objective {
    private final int id;
    private final String description;
    private final String targetColor;
    private final int idPlayer;
    private int idTarget;

    public ObjectiveEliminateTarget(int currentType, String colorTarget, String description, int idPlayer) {
        this.id = currentType;
        this.targetColor = colorTarget;
        this.description = description;
        this.idPlayer = idPlayer;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getIdPlayer() {
        return this.idPlayer;
    }

    public String getTargetColor() {
        return this.targetColor;
    }

    public int getIdTarget() {
        return this.idTarget;
    }

    public void setIdTarget(int IdTarget) {
        this.idTarget = IdTarget;
    }

    public String toString() { // Alterar depois
        return "Id objective " + this.id + "\n" + "Player for this objective " + this.idPlayer +
                "\n" + "Id target "  + this.idTarget + "\n" + "Target color " + this.targetColor;
    }
}