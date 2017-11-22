package moduleWork1.domain;

import moduleWork1.entitys.TaxiStation;

/**
 * 10.	Таксопарк.
 * Определить иерархию легковых автомобилей.
 * Создать таксопарк.
 * Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 *
 * @author Jesus Raichuk
 */
public class Main {
    static TaxiStation taxiStation;

    public static void main(String[] args) {
        taxiStation = new TaxiStation(20);
        taxiStation.printCarPark();

        System.out.println("\nPrice of car park = " + taxiStation.priceOfCarPark() + "$");

        taxiStation.sortByFuelConsumption();
        System.out.println("\nSorting by fuel consumption: ");
        taxiStation.printCarPark();

        System.out.println("\nCar by speed: " + taxiStation.findCarBySpeedRange(200, 300));
    }
}
