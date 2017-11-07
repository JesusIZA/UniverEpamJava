package epam.hw2;

import epam.hw2.abstracts.CVehicle;
import epam.hw2.entitys.*;
import java.util.Random;

/**
 * Abstract class for generation random CVehicle object
 */
public abstract class RandomCVehicle {
    /**
     * Method return random CVehicle object simple children such as:
     * CCar
     * CPlane
     * CShip
     * @return nextCVehicle(r.nextInt) - use nextCVehicle method for generation random CVehicle object (CVehicle type)
     */
    public static CVehicle randomSimpleOfTypesCVehicle() {
        Random r = new  Random();
        return nextCVehicle(r.nextInt(3));
    }
    /**
     * Method return random CVehicle object each of children such as:
     * CCar
     * CPlane
     * CShip
     * AmphibiaCar
     * BetCar
     * @return nextCVehicle(r.nextInt) - use nextCVehicle method for generation random CVehicle object (CVehicle type)
     */
    public static CVehicle randomEachOfTypesCVehicle() {
        Random r = new  Random();
        return nextCVehicle(r.nextInt(5));
    }
    /**
     * Generate and return each of children of CVehicle
     * @param key - number of children of CVehicle that need generate and return
     * @return CVehicle - generate one of child ov CVehicle(CCar, CPlane, CShip, AmphibiaCar, BetCar) fill one random values and return
     */
    public static CVehicle nextCVehicle(int key) {
        Random r = new  Random();
        switch (key) {
            case 0: return new CCar("CCar" + r.nextInt(1000), 50000 + r.nextInt(100000),
                        150 + r.nextInt(120), 1995 + r.nextInt(23));
            case 1: return new CPlane("CPlane" + r.nextInt(1000), 500000 + r.nextInt(500000),
                        400 + r.nextInt(1000), 1995 + r.nextInt(23),
                        70 + r.nextInt(100), 4000 + r.nextInt(3000));
            case 2: return new CShip("CShip" + r.nextInt(1000), 300000 + r.nextInt(200000),
                    150 + r.nextInt(70), 1995 + r.nextInt(23),
                    100 + r.nextInt(150), "NewPort" + r.nextInt(1000));
            case 3: return new AmphibiaCar("AmphibiaCar" + r.nextInt(1000), 200000 + r.nextInt(150000),
                    180 + r.nextInt(80), 1999 + r.nextInt(19));
            case 4: return new BetCar("BetCar" + r.nextInt(100), 600000 + r.nextInt(250000),
                    300 + r.nextInt(100), 2000 + r.nextInt(18));
            default: return null;
        }
    }
}
