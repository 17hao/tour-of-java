package xyz.shiqihao.designpattern.observer;

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
