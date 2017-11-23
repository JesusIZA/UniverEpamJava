package moduleWork1.domain;

import moduleWork1.entitys.TaxiStation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class realized console command listener for Taxi station
 *
 * @author Jesus Raichuk
 */
public class CommandListener {
    /**
     * Taxi station will processed
     */
    static TaxiStation taxiStation;

    public CommandListener() {
    }

    /**
     * Start console command listen
     */
    public void start() {
        Scanner scn = new Scanner(System.in);

        while (true) {
            String command = scn.next();
            if (command.equals("exit")) break;
            else {
                switch (command) {
                    case "create": {
                        create(scn);
                        break;
                    }
                    case "print": {
                        print();
                        break;
                    }
                    case "sort": {
                        sort();
                        break;
                    }
                    case "parkprice": {
                        parkPrice();
                        break;
                    }
                    case "findbyspeed": {
                        findBySpeed(scn);
                        break;
                    }
                    default: {
                        System.out.println("Command not found");
                    }
                }
            }
        }
        scn.close();
    }

    /**
     * Realize behavior program for command "findbyspeed"
     * @param scn - Scanner will read data from console
     */
    private void findBySpeed(Scanner scn) {
        if(taxiStation == null)
            System.out.println("Not created!!!");
        else {
            try {
                int min = scn.nextInt();
                int max = scn.nextInt();
                System.out.println("Car by speed: " + taxiStation.findCarBySpeedRange(min, max));
            } catch (InputMismatchException e) {
                System.out.println("Wrong parameters");
            }
        }
    }
    /**
     * Realize behavior program for command "parkprice"
     */
    private void parkPrice() {
        if(taxiStation == null)
            System.out.println("Not created!!!");
        else
            System.out.println("Price of car park = " + taxiStation.priceOfCarPark() + "$");
    }
    /**
     * Realize behavior program for command "sort"
     */
    private void sort() {
        if(taxiStation == null)
            System.out.println("Not created!!!");
        else {
            System.out.println("Sorted by fuel consumption");
            taxiStation.sortByFuelConsumption();
        }
    }
    /**
     * Realize behavior program for command "print"
     */
    private void print() {
        if(taxiStation == null)
            System.out.println("Not created!!!");
        else
            taxiStation.printCarPark();
    }
    /**
     * Realize behavior program for command "create"
     * @param scn - Scanner will read data from console
     */
    private void create(Scanner scn) {
        try {
            int size = scn.nextInt();
            taxiStation = new TaxiStation(size);
            System.out.println("Created");
        } catch (InputMismatchException e) {
            System.out.println("Wrong parameters");
        }
    }
}
