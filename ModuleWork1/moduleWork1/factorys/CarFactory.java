package moduleWork1.factorys;

import moduleWork1.entitys.Car;
import moduleWork1.factorys.types.ClosedFactory;
import moduleWork1.factorys.types.OpenedFactory;
import moduleWork1.factorys.types.TruckFactory;

import java.util.Random;

/**
 * Realize pattern Abstract factory
 *
 * Factory generate random type of a car with use three factory:
 * OpenedFactory - factory generate car with roof can open
 * ClosedFactory - factory generate car with closed roof
 * TruckFactory - factory generate truck car
 *
 * @author Jesus Raichuk
 */
public abstract class CarFactory {
    /**
     * Factory generate truck car
     */
    private static TruckFactory truckFactory;
    /**
     * Factory generate car with closed roof
     */
    private static ClosedFactory closedFactory;
    /**
     * Factory generate car with roof can open
     */
    private static OpenedFactory openedFactory;
    /**
     * Get random type car
     * @return - car
     */
    public static Car nextCar() {
        initializeFactory();
        Car car = null;
        Random r = new Random();
        switch (r.nextInt(3)) {
            case 0: {
                car = (Car)truckFactory.nextTruck();
                break;
            }
            case 1: {
                car = (Car)openedFactory.nextOpened();
                break;
            }
            case 2: {
                car = (Car)closedFactory.nextClosed();
                break;
            }
        }
        return car;
    }
    /**
     * Create each of factory types:
     * TruckFactory
     * ClosedFactory
     * OpenedFactory
     */
    private static void initializeFactory() {
        /**
         * Create truck factory
         */
        truckFactory = TruckFactory.getInstance();
        /**
         * Create closed factory
         */
        closedFactory = ClosedFactory.getInstance();
        /**
         * Create opened factory
         */
        openedFactory = OpenedFactory.getInstance();
    }
}
