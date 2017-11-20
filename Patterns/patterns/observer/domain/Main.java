package patterns.observer.domain;

import patterns.observer.realized.ChangeNumber;
import patterns.observer.realized.NumberDisplay;

public class Main {
    public static void main(String[] args) {
        ChangeNumber changeNumber = new ChangeNumber();

        NumberDisplay numberDisplay = new NumberDisplay(changeNumber);

        changeNumber.setMeasurements(10);
        changeNumber.setMeasurements(12);
        changeNumber.setMeasurements(15);
    }
}
