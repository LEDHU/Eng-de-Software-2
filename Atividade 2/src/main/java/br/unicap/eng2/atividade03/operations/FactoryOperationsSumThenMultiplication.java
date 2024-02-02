package br.unicap.eng2.atividade03.operations;

public class FactoryOperationsSumThenMultiplication implements FactoryOperations {
    @Override
    public Operation createBottomOperation() {
        return new OperationSum();
    }

    @Override
    public Operation createTopOperation() {
        return new OperationMultiplication();
    }
}