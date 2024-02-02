package br.unicap.nomedisciplina.atividade00.turn.attackPhase.dice;

import java.util.ArrayList;
import java.util.Collections;

public class DiceConfront {
    private final ArrayList<DiceStrategy> sourceDice;
    private final ArrayList<DiceStrategy> destinationDice;
    ArrayList<Integer> sourceResults;
    ArrayList<Integer> destinationResults;
    private final int sourceNumberDice;
    private final int destinationNumberDice;
    private int sourceLoss;
    private int destinationLoss;

    public DiceConfront(int sourceNumberDice, int destinationNumberDice) {
        this.sourceDice = new ArrayList<>();
        this.destinationDice = new ArrayList<>();
        this.sourceResults = new ArrayList<>();
        this.destinationResults = new ArrayList<>();
        this.sourceNumberDice = sourceNumberDice;
        this.destinationNumberDice = destinationNumberDice;
        this.sourceLoss = 0;
        this.destinationLoss = 0;
    }

    public DiceConfront(int sourceNumberDice, int destinationNumberDice, ArrayList<DiceStrategy> sourceDice, ArrayList<DiceStrategy> destinationDice) {
        this.sourceDice = sourceDice;
        this.destinationDice = destinationDice;
        this.sourceResults = new ArrayList<>();
        this.destinationResults = new ArrayList<>();
        this.sourceNumberDice = sourceNumberDice;
        this.destinationNumberDice = destinationNumberDice;
        this.sourceLoss = 0;
        this.destinationLoss = 0;
    }

    private void battleDices() {
        if(this.sourceDice.isEmpty()) {
            for (int i = 0; i < sourceNumberDice; i++) {
                sourceResults.add(new RandomDice().getValue());
            }
            for (int i = 0; i < destinationNumberDice; i++) {
                destinationResults.add(new RandomDice().getValue());
            }
        }else{
            for (int i = 0; i < sourceNumberDice; i++) {
                sourceResults.add(sourceDice.get(i).getValue());
            }
            for (int i = 0; i < destinationNumberDice; i++) {
                destinationResults.add(destinationDice.get(i).getValue());
            }
        }
        destinationResults.sort(Collections.reverseOrder());
        sourceResults.sort(Collections.reverseOrder());
    }

    public void calculateLoss() {
        battleDices();
        int maxNumOfPair = Math.min(this.sourceNumberDice, this.destinationNumberDice);
        for (int i = 0; i < maxNumOfPair; i++) {
            if (this.sourceResults.get(i) > this.destinationResults.get(i)) {
                this.destinationLoss += 1;
            } else {
                this.sourceLoss += 1;
            }
        }
    }

    public int getSourceLoss() {
        return sourceLoss;
    }

    public int getDestinationLoss() {
        return destinationLoss;
    }
}