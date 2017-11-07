package epam.hw2.entitys;

import epam.hw2.abstracts.CVehicle;
import epam.hw2.interfaces.FlyAble;
import epam.hw2.interfaces.ForPassenger;
/**
 * Class CPlane extends CVehicle and implements FlyAble and ForPassenger
 * Class that realized object is plane
 */
public class CPlane extends CVehicle implements FlyAble, ForPassenger{
    /**
     * Number of passengers
     */
    private int passengers;
    /**
     * Max height plane can rise to
     */
    private int height;
    /**
     * Default constructor
     */
    public CPlane() {
        super();
    }
    /**
     * Constructor create CPlane object with vehicle make, number of passengers and max height plane can rise to
     * @param make - vehicle make (String)
     * @param passengers - number of passengers (int)
     * @param height - max height plane can rise to (int)
     */
    public CPlane(String make, int passengers, int height) {
        super(make);
        this.passengers = passengers;
        this.height = height;
    }
    /**
     * Constructor create CPlane object with vehicle make, price, max speed, production year, number of passengers and max height plane can rise to
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     * @param passengers - number of passengers (int)
     * @param height - max height plane can rise to (int)
     */
    public CPlane(String make, int price, int speed, int year, int passengers, int height) {
        super(make, price, speed, year);
        this.passengers = passengers;
        this.height = height;
    }
    /**
     * Method get max height plane can rise to
     * @return height - max height plane can rise to (int)
     */
    public int getHeight() {
        return height;
    }
    /**
     * Method set max height plane can rise to
     * @param height - max height plane can rise to (must be int type)
     */
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int fly() {
        return this.getSpeed() * 10;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return super.toString() + "->CPlane{" +
                "passengers=" + this.getPassengers() +
                ", fly=" + this.fly() +
                ", height='" + height + '\'' +
                '}';
    }
}
