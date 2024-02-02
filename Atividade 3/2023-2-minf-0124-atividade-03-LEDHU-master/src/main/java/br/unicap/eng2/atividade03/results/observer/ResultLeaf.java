package br.unicap.eng2.atividade03.results.observer;

import java.util.ArrayList;
import java.util.List;

public class ResultLeaf implements ResultComponent {
    private double result;
    private final List<ResultObserver> observers = new ArrayList<>();

    public ResultLeaf(double result) {
        this.result = result;
    }

    @Override
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
        System.out.println("Setting result of ResultLeaf1 to: " + result);
        notifyObservers();
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
    public void notifyObservers(ResultObserver observer) {

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
        if(subject instanceof ResultComposite) {
            ResultComposite composite = (ResultComposite) subject;
            this.result = composite.getResult();
        }
    }
}

