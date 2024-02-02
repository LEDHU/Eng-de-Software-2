package br.unicap.nomedisciplina.atividade00.match.Objective;

public class ObjectiveConquestTerritorySpecific implements Objective {
    private final int id;
    private final String description;
    private final int idPlayer;

    public ObjectiveConquestTerritorySpecific(int currentType, String description, int idPlayer) {
        this.id = currentType;
        this.description = description;
        this.idPlayer = idPlayer;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getIdPlayer() {
        return this.idPlayer;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}