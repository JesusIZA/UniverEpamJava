package moduleWork1.factorys.types;

import moduleWork1.cars.Sedan;
import moduleWork1.cars.Universal;
import moduleWork1.interfaces.carsTypes.Closed;

import java.util.Random;

/**
 * Realize pattern Singleton
 *
 * Factory generate Closed type of a car with random parameters:
 *
 * @author Jesus Raichuk
 */
public class ClosedFactory {
    private static ClosedFactory instance;

    private ClosedFactory() {}

    public static ClosedFactory getInstance() {
        if (instance == null)
            instance = new ClosedFactory();
        return instance;
    }
    /**
     * Get Closed car two types:
     * Sedan
     * Universal
     * Closed car has random parameters
     * @return - Closed car
     */
    public static Closed nextClosed(){
        Closed closed = null;
        Random r = new  Random();
        switch (r.nextInt(2)){
            case 0: {
                closed = new Sedan(2000 + r.nextInt(4000), 5 + r.nextInt(10),
                        200 + r.nextInt(100), 4 + r.nextInt(3));
                break;
            }
            case 1: {
                closed = new Universal(3000 + r.nextInt(5000), 7 + r.nextInt(10),
                        180 + r.nextInt(100), 5 + r.nextInt(4));
                break;
            }
        }
        return closed;
    }
}
