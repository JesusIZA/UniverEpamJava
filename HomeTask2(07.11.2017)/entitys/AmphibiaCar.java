package epam.hw2.entitys;


import epam.hw2.interfaces.SwimAble;

public class AmphibiaCar extends CCar implements SwimAble {
    /**
     * Default constructor
     */
    public AmphibiaCar() {
        super();
    }
    /**
     * Constructor create AmphibiaCar object with vehicle make
     * @param make - vehicle make (String)
     */
    public AmphibiaCar(String make) {
        super(make);
    }
    /**
     * Constructor create AmphibiaCar object with vehicle make, price, max speed and production year
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     */
    public AmphibiaCar(String make, int price, int speed, int year) {
        super(make, price, speed, year);
    }

    @Override
    public int swim() {
        return this.getSpeed() / 3;
    }

    @Override
    public String toString() {
        return super.toString() + "->AmphibiaCar{swim=" + this.swim() + "}";
    }
}
