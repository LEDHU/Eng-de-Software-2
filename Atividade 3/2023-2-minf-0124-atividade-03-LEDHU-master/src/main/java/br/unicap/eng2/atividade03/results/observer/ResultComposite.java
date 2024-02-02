package br.unicap.eng2.atividade03.results.observer;
import br.unicap.eng2.atividade03.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class ResultComposite implements ResultComponent {
    private final List<ResultComponent> components = new ArrayList<>();
    private final List<ResultObserver> observers = new ArrayList<>();
    private final Operation operation;

    public ResultComposite(Operation operation) {
        this.operation = operation;
    }

    public void addResult(ResultComponent component) {
        System.out.println("Adding ResultLeaf1 to ResultCompositeBottomLeft");
        components.add(component);
        component.attach(this);
        notifyObservers();
    }

    @Override
    public double getResult() {
        double result = components.get(0).getResult();
        for (int i= 1; i < components.size(); i = i+1) {
            ResultComponent component = components.get(i);
            result = operation.calculate(result, component.getResult());
        }
        System.out.println("Getting result of ResultComponent: " + result);
        return result;
    }

    @Override
    public void attach(ResultObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ResultObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying observers");
        for (ResultObserver observer : observers) {
            System.out.println("Notifying observer: " + observer);
            observer.update(this);
        }
    }

    @Override
    public void update(ResultSubject subject) {
        notifyObservers();
    }
}