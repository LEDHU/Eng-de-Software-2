package br.unicap.nomedisciplina.atividade00.match;

import java.util.ArrayList;

public class Territory {
    private Player player;
    private final ArrayList<Territory> adjacent;
    private final String name;
    private int qtdArmies;

    public Territory(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The territory name cannot be null or empty");
        }
        this.name = name;
        this.adjacent = new ArrayList<>();
        this.qtdArmies = 0;
    }

    public Territory(String name, Player player) {
        this(name);
        this.player = player;
        this.qtdArmies = player.getTotalArmys();
    }

    public int getQtdArmies() {
        return qtdArmies;
    }

    public void setQtdArmies(int qtdArmies) {
        this.qtdArmies = qtdArmies;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Territory> getAdjacentTerritories() {
        return adjacent;
    }

    public String getName() {
        return name;
    }

    public void addAdjacentTerritory(Territory adjacentTerritory) {
            adjacent.add(adjacentTerritory);
    }
    public void addArmies(int qtdArmies) {
        this.qtdArmies += qtdArmies;
    }

    public void removeArmies(int qtdArmies) {
        this.qtdArmies -= qtdArmies;
    }
}
