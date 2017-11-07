package epam.hw2.abstracts;

/**
 * Abstract class that realized object that can move and is vehicle
 * Like car, ship or plane...
 */
public abstract class CVehicle {
    /**
     * What is vehicle make
     */
    private String make;
    /**
     * Price of the vehicle
     */
    private int price;
    /**
     * Max speed vehicle can move
     */
    private int speed;
    /**
     * Production year
     */
    private int year;

    /**
     * Default constructor
     */
    public CVehicle() {
        super();
    }
    /**
     * Constructor create CVehicle object with vehicle make
     * @param make - vehicle make (String)
     */
    public CVehicle(String make) {
        super();
        this.make = make;
    }
    /**
     * Constructor create CVehicle object with vehicle make, price, max speed and production year
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     */
    public CVehicle(String make, int price, int speed, int year) {
        super();
        this.make = make;
        this.price = price;
        this.speed = speed;
        this.year = year;
    }
    /**
     * Method get price of the vehicle
     * @return price - price of the vehicle (int)
     */
    public int getPrice() {
        return price;
    }
    /**
     * Method set price of the vehicle
     * @param price - price of the vehicle (must be int type)
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Method get max speed vehicle can move
     * @return speed - max speed vehicle can move (int)
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Method set max speed vehicle can move
     * @param speed - max speed vehicle can move (must be int type)
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * Method get production year
     * @return year - production year (int)
     */
    public int getYear() {
        return year;
    }
    /**
     * Method set production year
     * @param year - production year (must be int type)
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     *Method get what is vehicle make
     * @return make - what is vehicle make (String)
     */
    public String getMake() {
        return this.make;
    }
    /**
     * Method set what is vehicle make
     * @param make - what is vehicle make (must be String type)
     */
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "CVehicle{" +
                "Make='" + make + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                ", year=" + year +
                '}';
    }
}
