package br.unicap.eng2.atividade03.results.observer;

public interface ResultComponent extends ResultObserver, ResultSubject {
    double getResult();

    void notifyObservers();
}