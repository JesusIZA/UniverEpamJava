package moduleWork1.factorys.types;

import moduleWork1.cars.Cabriolet;
import moduleWork1.cars.Roadster;
import moduleWork1.interfaces.carsTypes.Opened;

import java.util.Random;

/**
 * Realize pattern Singleton
 *
 * Factory generate Opened type of a car with random parameters:
 *
 * @author Jesus Raichuk
 */
public class OpenedFactory {
    private static OpenedFactory instance;

    private OpenedFactory() {}

    public static OpenedFactory getInstance() {
        if (instance == null)
            instance = new OpenedFactory();
        return instance;
    }
    /**
     * Get Opened car two types:
     * Cabriolet
     * Roadster
     * Opened car has random parameters
     * @return - Opened car
     */
    public static Opened nextOpened(){
        Opened opened = null;
        Random r = new  Random();
        switch (r.nextInt(2)){
            case 0: {
                opened = new Cabriolet(2000 + r.nextInt(5000), 6 + r.nextInt(10),
                        220 + r.nextInt(50), 130 + r.nextInt(90));
                break;
            }
            case 1: {
                opened = new Roadster(2500 + r.nextInt(5000), 8 + r.nextInt(10),
                        200 + r.nextInt(80), 130 + r.nextInt(70));
                break;
            }
        }
        return opened;
    }
}
