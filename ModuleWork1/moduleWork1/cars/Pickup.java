package moduleWork1.cars;

import moduleWork1.entitys.Car;
import moduleWork1.interfaces.carsTypes.Truck;

/**
 * Class realize truck Car
 * Car has Pickup type body
 *
 * @author Jesus Raichuk
 */
public class Pickup extends Car implements Truck{
    private int maxLoadCapacity;

    public Pickup(int price, int fuelConsumption, int speed, int maxLoadCapacity) {
        super(price, fuelConsumption, speed);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public int maxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String typeName() {
        return "Pickup";
    }

    @Override
    public String toString() {
        return super.toString() + "->Pickup{" +
                "maxLoadCapacity=" + maxLoadCapacity +
                "t}";
    }


}
