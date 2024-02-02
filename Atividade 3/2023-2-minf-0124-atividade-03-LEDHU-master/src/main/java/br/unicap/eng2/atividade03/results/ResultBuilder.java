package br.unicap.eng2.atividade03.results;

import br.unicap.eng2.atividade03.operations.FactoryOperations;

public class ResultBuilder {
    private final FactoryOperations factroy;

    public ResultBuilder(FactoryOperations factory) {
        this.factroy = factory;
    }

    public ResultComponent buildOperations(double[] leftValues, double[] rightValues) {
        ResultComponent leftComposite = buildComposite(leftValues);
        ResultComponent rightComposite = buildComposite(rightValues);

        ResultComposite result = new ResultComposite(factroy.createTopOperation());
        result.add(leftComposite);
        result.add(rightComposite);

        return result;
    }

    private ResultComponent buildComposite(double[] values) {
        ResultComposite composite = new ResultComposite(factroy.createBottomOperation());
        for (double value : values) {
            composite.add(new ResultLeaf(value));
        }
        return composite;
    }
}