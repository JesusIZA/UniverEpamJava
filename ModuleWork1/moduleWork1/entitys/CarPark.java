package moduleWork1.entitys;

import moduleWork1.interfaces.Iterator;

import java.util.List;

/**
 * Class realize pattern Iterator
 *
 * Also realized Car park
 *
 * @author Jesus Raichuk
 */
public class CarPark  implements Iterator{
    /**
     * List of cars
     */
    private List<Car> cars;
    /**
     * Position reference for counter for hasNext method
     */
    private int position = 0;

    public CarPark(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean hasNext() {
        if(position >= cars.size() || cars.get(position) == null)
            return false;
        else
            return true;
    }

    @Override
    public Car next() {
        Car car = cars.get(position);
        position += 1;
        return car;
    }
}
