package moduleWork1.factorys.types;

import moduleWork1.cars.Pickup;
import moduleWork1.cars.Van;
import moduleWork1.interfaces.carsTypes.Truck;

import java.util.Random;

/**
 * Realize pattern Singleton
 *
 * Factory generate Truck type of a car with random parameters:
 *
 * @author Jesus Raichuk
 */
public class TruckFactory {
    private static TruckFactory instance;

    private TruckFactory() {}

    public static TruckFactory getInstance() {
        if (instance == null)
            instance = new TruckFactory();
        return instance;
    }
    /**
     * Get Truck car two types:
     * Pickup
     * Van
     * Truck car has random parameters
     * @return - Truck car
     */
    public static Truck nextTruck(){
        Truck truck = null;
        Random r = new  Random();
        switch (r.nextInt(2)){
            case 0: {
                truck = new Pickup(4000 + r.nextInt(2000), 10 + r.nextInt(10),
                        150 + r.nextInt(50), 4 + r.nextInt(4));
                break;
            }
            case 1: {
                truck = new Van(5000 + r.nextInt(2000), 12 + r.nextInt(10),
                        180 + r.nextInt(50), 3 + r.nextInt(2));
                break;
            }
        }
        return truck;
    }
}
