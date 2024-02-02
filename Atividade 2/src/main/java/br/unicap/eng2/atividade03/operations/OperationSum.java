package br.unicap.eng2.atividade03.operations;

public class OperationSum implements Operation {
    @Override
    public double calculate(double value1, double value2) {
        return value1 + value2;
    }
}