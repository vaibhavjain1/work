package designPatterns;

import java.util.HashSet;
import java.util.Set;

interface Observer{
    Observable observable = new Observable();
    void doWork();
}

class Observer1 implements Observer{
    Observer1(){
        observable.addObserver(this);
    }
    @Override
    public void doWork() {
        // Inside observer1
    }
}

class Observable{
    Set<Observer> observerSet = new HashSet<>();

    public void addObserver(Observer observer){
        observerSet.add(observer);
    }

    public void removeObserver(Observer observer){
        observerSet.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer: observerSet){
            observer.doWork();
        }
    }
}

public class ObserverDemo {

}
