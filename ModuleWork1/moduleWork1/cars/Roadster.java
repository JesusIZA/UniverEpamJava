package moduleWork1.cars;

import moduleWork1.entitys.Car;
import moduleWork1.interfaces.carsTypes.Opened;

/**
 * Class realize Car with roof can open
 * Car has Roadster type body
 *
 * @author Jesus Raichuk
 */
public class Roadster extends Car implements Opened {
    private int maxSpeedWithOpenRoof;

    public Roadster(int price, int fuelConsumption, int speed, int maxSpeedWithOpenRoof) {
        super(price, fuelConsumption, speed);
        this.maxSpeedWithOpenRoof = maxSpeedWithOpenRoof;
    }

    @Override
    public int maxSpeedWithOpenRoof() {
        return maxSpeedWithOpenRoof;
    }

    @Override
    public String typeName() {
        return "Roadster";
    }

    @Override
    public String toString() {
        return super.toString() + "->Roadster{" +
                "maxSpeedWithOpenRoof=" + maxSpeedWithOpenRoof +
                "km/h}";
    }

}
