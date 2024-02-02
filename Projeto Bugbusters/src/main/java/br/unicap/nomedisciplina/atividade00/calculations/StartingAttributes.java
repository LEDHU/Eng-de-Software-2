package br.unicap.nomedisciplina.atividade00.calculations;

public class StartingAttributes {
    private final int totalTerritory;
    private final String[] color;
    private final String[] description;
    private int earlyArmys;

    public StartingAttributes() {
        this.totalTerritory = 42;
        this.color = new String[]{"Blue", "Red", "Yellow", "Green", "Black", "White"};
        this.description = new String[]{"Completely eliminate the target's red army. If this color is not in the game or the target player has already been eliminated, conquer 24 territories instead.", "Conquer 24 territories of your choice", "Conquer all territories in Asia and Europe entirely."};
    }

    public int getTotalTerritory() {
        return totalTerritory;
    }

    public String[] getColor() {
        return color;
    }

    public String[] getDescription() {
        return description;
    }

    public int getEarlyArmys() {
        return earlyArmys;
    }

    public void setEarlyArmys(int earlyArmys) {
        this.earlyArmys = earlyArmys;
    }
}