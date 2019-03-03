package by.training.taskobject.observer;

import by.training.taskobject.repository.Repository;

public interface Observable {

    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
