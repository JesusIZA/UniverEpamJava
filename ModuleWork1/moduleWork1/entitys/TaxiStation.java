package moduleWork1.entitys;

import moduleWork1.entitys.Car;
import moduleWork1.entitys.CarPark;
import moduleWork1.factorys.CarFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 10.	Таксопарк.
 * Определить иерархию легковых автомобилей.
 * Создать таксопарк.
 * Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 *
 * Class realized Taxi station
 *
 * @author Jesus Raichuk
 */
public class TaxiStation {
    /**
     * Car park list
     */
    CarPark carPark;

    /**
     * Constructor create new taxi station and fill one random cars
     * @param size - size of car park
     */
    public TaxiStation(final int size) {
        this.carPark = createCarPark(size);
    }

    /**
     * Create Car park
     * @param size - size Car park
     * @return - CarParc
     */
    private CarPark createCarPark(final int size) {
        List taxis = new LinkedList<Car>();
        for (int i = 0; i < size; i++) {
            taxis.add(CarFactory.nextCar());
        }
        return new CarPark(taxis);
    }

    /**
     * Get summary price fro all cars in Car park of Taxi station
     * @return
     */
    public int priceOfCarPark() {
        carPark.setPosition(0);
        int price = 0;
        while (carPark.hasNext()){
            price += carPark.next().getPrice();
        }
        return price;
    }

    /**
     * Sort Car park by fuel consumption
     */
    public void sortByFuelConsumption(){
        for (int d = carPark.getCars().size() / 2; d >= 1; d /= 2)
            for (int i = d; i < carPark.getCars().size(); i++)
                for (int j = i; j >= d && carPark.getCars().get(j-d).getFuelConsumption() > carPark.getCars().get(j).getFuelConsumption(); j -= d) {
                    Car temp = carPark.getCars().get(j);
                    carPark.getCars().remove(j);
                    carPark.getCars().add(j - 1, temp);
                }
    }

    /**
     * Get Car has speed in range from min to max
     * @param min - bottom line for speed
     * @param max - top line for speed
     * @return - car has sped in range will put
     * @throws NullPointerException - if car with need speed wasn't find
     */
    public Car findCarBySpeedRange(int min, int max) throws NullPointerException {
        carPark.setPosition(0);
        Car res = null;
        while (carPark.hasNext()) {
            Car car = carPark.next();
            if(car.getSpeed() >= min && car.getSpeed() <= max) {
                res = car;
                break;
            }
        }
        return res;
    }

    /**
     * Print each item in Car park
     */
    public void printCarPark(){
        carPark.setPosition(0);
        while (carPark.hasNext())
            System.out.println(carPark.next());
    }
}
