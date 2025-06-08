package model.interfaces;

public interface Observable {

    void addObserver(Observer o);

    void notifyObservers(Object args);

}
