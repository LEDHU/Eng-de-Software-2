package br.unicap.eng2.atividade03.results;

import java.util.ArrayList;
import java.util.List;

import br.unicap.eng2.atividade03.operations.Operation;

public class ResultComposite implements ResultComponent {
    private final List<ResultComponent> lista = new ArrayList<>();
    private final Operation operation;

    public ResultComposite(Operation operation) {
        this.operation = operation;
    }

    public void add(ResultComponent child) {
        lista.add(child);
    }

    @Override
    public double getResult() {
        if (lista.isEmpty()) {
            return 0.0;
        }

        double result = lista.get(0).getResult();

        for (int i = 1; i < lista.size(); i++) {
            result = operation.calculate(result, lista.get(i).getResult());
        }

        return result;
    }
}