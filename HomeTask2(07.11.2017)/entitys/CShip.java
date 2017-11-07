package epam.hw2.entitys;

import epam.hw2.abstracts.CVehicle;
import epam.hw2.interfaces.ForPassenger;
import epam.hw2.interfaces.SwimAble;
/**
 * Class CShip extends CVehicle and implements SwimAble and ForPassenger
 * Class that realized object is ship
 */
public class CShip extends CVehicle implements SwimAble, ForPassenger {
    /**
     * Number of passengers
     */
    private int passengers;
    /**
     *Port of registration
     */
    private String port;
    /**
     * Default constructor
     */
    public CShip() {
        super();
    }
    /**
     * Constructor create CShip object with vehicle make, number of passengers and port of registration
     * @param make - vehicle make (String)
     * @param passengers - number of passengers (int)
     * @param port - max port of registration (int)
     */
    public CShip(String make, int passengers, String port) {
        super(make);
        this.passengers = passengers;
        this.port = port;
    }
    /**
     * Constructor create CShip object with vehicle make, price, max speed, production year, number of passengers and port of registration
     * @param make - vehicle make (String)
     * @param price - price (int)
     * @param speed - max speed (int)
     * @param year - production year (int)
     * @param passengers - number of passengers (int)
     * @param port - port of registration (int)
     */
    public CShip(String make, int price, int speed, int year, int passengers, String port) {
        super(make, price, speed, year);
        this.passengers = passengers;
        this.port = port;
    }
    /**
     * Method get port of registration
     * @return port - port of registration (String)
     */
    public String getPort() {
        return port;
    }
    /**
     * Method set port of registration
     * @param port - port of registration (must be String type)
     */
    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public int swim() {
        return this.getSpeed() / 2;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return super.toString() + "->CShip{" +
                "passengers=" + this.getPassengers() +
                ", swim=" + this.swim() +
                ", port='" + port + '\'' +
                '}';
    }
}
