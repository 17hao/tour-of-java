package xyz.shiqihao.designpattern.behavioral.observer;

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
