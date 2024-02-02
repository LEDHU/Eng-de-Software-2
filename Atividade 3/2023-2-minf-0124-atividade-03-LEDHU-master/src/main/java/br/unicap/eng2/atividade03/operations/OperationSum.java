package br.unicap.eng2.atividade03.operations;

public class OperationSum implements Operation {
    @Override
    public double calculate(double va1, double va2) {
        return va1+va2;
    }
}