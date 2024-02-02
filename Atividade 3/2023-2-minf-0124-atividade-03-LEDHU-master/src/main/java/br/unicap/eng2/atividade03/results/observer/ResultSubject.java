package br.unicap.eng2.atividade03.results.observer;

public interface ResultSubject {
    void attach(ResultObserver observer);
    void detach(ResultObserver observer);
    void notifyObservers(ResultObserver observer);
}