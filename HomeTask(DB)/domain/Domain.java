package homeWork.hw8.domain;

import homeWork.hw8.etitys.Airline;
import homeWork.hw8.etitys.Flight;
import homeWork.hw8.service.AirlineService;
import homeWork.hw8.service.FlightService;
import utilsforall.lists.PrintLists;

/**
 * @author Jesus Raichuk
 */
public class Domain {
    public static void main(String[] args) {
        /**
         * Create service for Airline
         */
        AirlineService airlineService = new AirlineService();
        /**
         * Create service for Airline
         */
        FlightService flightService = new FlightService();
        /**
         * Create new Airline (a1)
         */
        Airline a1 = new Airline(1, "OneA");
        /**
         * Create new Airline (a2)
         */
        Airline a2 = new Airline(2, "TwoA");
        //adding Airlines (a1, a2) to DB
        airlineService.add(a1);
        airlineService.add(a2);
        /**
         * Create new Flight (f1)
         */
        Flight f1 = new Flight(1, 1, "Kyiv", "Rivne", 1.2);
        /**
         * Create new Flight (f2)
         */
        Flight f2 = new Flight(2, 1, "Kyiv", "Praga", 2.3);
        /**
         * Create new Flight (f3)
         */
        Flight f3 = new Flight(3, 2, "Rivne", "Budapest", 4.1);
        /**
         * Create new Flight (f4)
         */
        Flight f4 = new Flight(4, 2, "Rivne", "Kharkiv", 0.5);
        //adding Flights (f1, f2, f3, f4) to DB
        flightService.add(f1);
        flightService.add(f2);
        flightService.add(f3);
        flightService.add(f4);
        //Print all data from DB
        System.out.println();
        PrintLists.printListByRows(airlineService.getAll());
        PrintLists.printListByRows(flightService.getAll());

        Airline a1u = new Airline(1, "OneNew");
        Flight f1u = new Flight(1, 1, "Kyiv", "Rome", 1.2);
        airlineService.update(a1u);
        flightService.update(f1u);
        //Print all data from DB
        System.out.println();
        PrintLists.printListByRows(airlineService.getAll());
        PrintLists.printListByRows(flightService.getAll());
        //Delete half data from DB
        flightService.delete(f1u);
        flightService.delete(f2);
        airlineService.delete(a1u);
        //Print all data from DB
        System.out.println();
        PrintLists.printListByRows(airlineService.getAll());
        PrintLists.printListByRows(flightService.getAll());
        //Delete all data from DB
        flightService.delete(f3);
        flightService.delete(f4);
        airlineService.delete(a2);
        System.out.println();
        System.out.println("All are deleted!!!");
        //Close connection to DB
        airlineService.stopConnection();
        flightService.stopConnection();
    }
}
