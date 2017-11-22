package moduleWork1.cars;

import moduleWork1.entitys.Car;
import moduleWork1.interfaces.carsTypes.Truck;

/**
 * Class realize truck Car
 * Car has Van type body
 *
 * @author Jesus Raichuk
 */
public class Van extends Car implements Truck {
    private int maxLoadCapacity;

    public Van(int price, int fuelConsumption, int speed, int maxLoadCapacity) {
        super(price, fuelConsumption, speed);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public int maxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String typeName() {
        return "Van";
    }

    @Override
    public String toString() {
        return super.toString() + "->Van{" +
                "maxLoadCapacity=" + maxLoadCapacity +
                "t}";
    }


}
