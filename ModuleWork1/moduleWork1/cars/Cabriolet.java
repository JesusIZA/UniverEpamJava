package moduleWork1.cars;

import moduleWork1.entitys.Car;
import moduleWork1.interfaces.carsTypes.Opened;

/**
 * Class realize Car with roof can open
 * Car has Cabriolet type body
 *
 * @author Jesus Raichuk
 */
public class Cabriolet extends Car implements Opened {
    /**
     * Maximum speed the car can move with open roof
     */
    private int maxSpeedWithOpenRoof;

    public Cabriolet(int price, int fuelConsumption, int speed, int maxSpeedWithOpenRoof) {
        super(price, fuelConsumption, speed);
        this.maxSpeedWithOpenRoof = maxSpeedWithOpenRoof;
    }

    @Override
    public int maxSpeedWithOpenRoof() {
        return maxSpeedWithOpenRoof;
    }

    @Override
    public String typeName() {
        return "Cabriolet";
    }

    @Override
    public String toString() {
        return super.toString() + "->Cabriolet{" +
                "maxSpeedWithOpenRoof=" + maxSpeedWithOpenRoof +
                "km/h}";
    }

}
