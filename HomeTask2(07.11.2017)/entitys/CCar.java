package epam.hw2.entitys;

import epam.hw2.abstracts.CVehicle;
import epam.hw2.interfaces.MoveAble;

/**
 * Class CCar extends CVehicle and implements MoveAble
 * Class that realized object is car
 */
public class CCar extends CVehicle implements MoveAble {
    /**
     * Default constructor
     */
    public CCar() {
        super();
    }
    /**
     * Constructor create CCar object with vehicle make
     * @param make - vehicle make (String)
     */
    public CCar(String make) {
        super(make);
    }
    /**
     * Constructor create CCar object with vehicle make, price, max speed and production year
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     */
    public CCar(String make, int price, int speed, int year) {
        super(make, price, speed, year);
    }

    @Override
    public int move() {
        return this.getSpeed();
    }

    @Override
    public String toString() {
        return super.toString() + "->CCar{move=" + this.move() + "}";
    }
}
