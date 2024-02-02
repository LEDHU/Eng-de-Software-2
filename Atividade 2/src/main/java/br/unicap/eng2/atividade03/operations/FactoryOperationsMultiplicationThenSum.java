package br.unicap.eng2.atividade03.operations;

public class FactoryOperationsMultiplicationThenSum implements FactoryOperations {
    @Override
    public Operation createBottomOperation() {
        return new OperationMultiplication();
    }

    @Override
    public Operation createTopOperation() {
        return new OperationSum();
    }
}