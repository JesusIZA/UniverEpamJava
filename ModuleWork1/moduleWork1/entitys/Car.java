package moduleWork1.entitys;

/**
 * Abstract class realized Car
 *
 * @author Jesus Raichuk
 */
public abstract class Car {
    private int price;
    private int fuelConsumption;
    private int speed;

    public Car(int price, int fuelConsumption, int speed) {
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public abstract String typeName();

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                "$, fuelConsumption=" + fuelConsumption +
                "L, speed=" + speed +
                "km/h" +
                '}';
    }
}
