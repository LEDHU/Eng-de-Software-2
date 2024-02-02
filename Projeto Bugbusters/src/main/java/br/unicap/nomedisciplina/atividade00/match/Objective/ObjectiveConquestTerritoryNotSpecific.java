package br.unicap.nomedisciplina.atividade00.match.Objective;

public class ObjectiveConquestTerritoryNotSpecific implements Objective {
    private final int id;
    private final String description;
    private final int quantityConquered;
    private final int idPlayer;

    public ObjectiveConquestTerritoryNotSpecific(int currentType, String description, int idPlayer) {
        this.id = currentType;
        this.description = description;
        this.quantityConquered = 24;
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

    public int getQuantityConquered() {
        return this.quantityConquered;
    }

    public String toString() { // Alterar depois
        return "Id objective " + this.id + "\n" + "Player for this objective " + this.idPlayer +
                "\n" + "Quantity to conquer " + this.quantityConquered;
    }
}