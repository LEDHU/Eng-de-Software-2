package br.unicap.eng2.atividade03.results.observer;

import br.unicap.eng2.atividade03.operations.FactoryOperations;

public class ResultBuilder {
    private final FactoryOperations factoryOperations;

    public ResultBuilder(FactoryOperations factoryOperations) {
        this.factoryOperations = factoryOperations;
    }

    public ResultComponent buildOperations(ResultLeaf[] leftValues, ResultLeaf[] rightValues, ResultComposite bottomLeftComposite, ResultComposite bottomRightComposite) {
        ResultComposite topComposite = new ResultComposite(factoryOperations.createTopOperation());

        for (ResultLeaf leftValue : leftValues) {
            bottomLeftComposite.addResult(leftValue);
        }

        for (ResultLeaf rightValue : rightValues) {
            bottomRightComposite.addResult(rightValue);
        }

        topComposite.addResult(bottomLeftComposite);
        topComposite.addResult(bottomRightComposite);
        return topComposite;
    }
}