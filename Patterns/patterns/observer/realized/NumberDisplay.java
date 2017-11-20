package patterns.observer.realized;

import patterns.observer.interfaces.DisplayElement;
import patterns.observer.interfaces.Observer;
import patterns.observer.interfaces.Subject;

public class NumberDisplay implements Observer, DisplayElement {
    private int number;
    Subject numObserver;

    public NumberDisplay(Subject numObserver) {
        this.numObserver = numObserver;
        numObserver.registerObserver(this);
    }

    @Override
    public void update(int number) {
        this.number = number;
        display();
    }

    @Override
    public void display() {
        System.out.println("Number: " + number);
    }
}
