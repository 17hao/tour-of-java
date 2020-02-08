package xyz.shiqihao.designpattern.behavioral.observer.example_1;

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
