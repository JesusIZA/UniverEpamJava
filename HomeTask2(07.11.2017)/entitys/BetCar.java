package epam.hw2.entitys;

import epam.hw2.interfaces.FlyAble;

public class BetCar extends CCar implements FlyAble {
    /**
     * Default constructor
     */
    public BetCar() {
        super();
    }
    /**
     * Constructor create BetCar object with vehicle make
     * @param make - vehicle make (String)
     */
    public BetCar(String make) {
        super(make);
    }
    /**
     * Constructor create BetCar object with vehicle make, price, max speed and production year
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     */
    public BetCar(String make, int price, int speed, int year) {
        super(make, price, speed, year);
    }

    @Override
    public int fly() {
        return this.getSpeed() * 5;
    }

    @Override
    public String toString() {
        return super.toString() + "->BetCar{fly=" + this.fly() + "}";
    }
}
