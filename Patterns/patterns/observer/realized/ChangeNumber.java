package patterns.observer.realized;

import patterns.observer.interfaces.Observer;
import patterns.observer.interfaces.Subject;

import java.util.ArrayList;

public class ChangeNumber implements Subject {
    private int number;
    private ArrayList observers;

    public ChangeNumber () {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        if(observers.indexOf(obs) >= 0){
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer obs = (Observer)observers.get(i);
            ((Observer) observers.get(i)).update(number);
        }
    }

    public void measurementsChange(){
        notifyObservers();
    }

    public  void setMeasurements(int num){
        this.number = num;
        measurementsChange();
    }
}
