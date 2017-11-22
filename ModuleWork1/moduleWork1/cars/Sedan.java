package moduleWork1.cars;

import moduleWork1.entitys.Car;
import moduleWork1.interfaces.carsTypes.Closed;

/**
 * Class realize Car with closed roof
 * Car has Sedan type body
 *
 * @author Jesus Raichuk
 */
public class Sedan extends Car implements Closed {

    private int maxPassengerCapacity;

    public Sedan(int price, int fuelConsumption, int speed, int maxPassengerCapacity) {
        super(price, fuelConsumption, speed);
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    @Override
    public int maxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    @Override
    public String typeName() {
        return "Sedan";
    }

    @Override
    public String toString() {
        return super.toString() + "->Sedan{" +
                "maxPassengerCapacity=" + maxPassengerCapacity +
                '}';
    }

}
