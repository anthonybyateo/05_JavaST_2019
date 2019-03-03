package by.training.taskobject.observer;

public interface Observable {

    public void attach(Observer ob);
    public void detach(Observer ob);
    public void notifyObservers();
}
