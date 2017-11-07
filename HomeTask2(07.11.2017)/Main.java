package epam.hw2;

import epam.hw2.abstracts.CVehicle;
import epam.hw2.entitys.*;
import epam.hw2.interfaces.FlyAble;
import epam.hw2.interfaces.MoveAble;
import epam.hw2.interfaces.SwimAble;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Создать абстрактный класс CVehicle. На его основе реализовать классы CPlane, CCar, CShip.
 * Классы должны иметь возмлжность задавать и получать координаты, параметры средств передвижения (цена, скорость, год выпуска).
 * Для самолетаа должна быть определена высота, для самолета и корабля - количество пасажиров. Для корабля - порт приписки.
 *
 * Написать программу, создающую список объектов этих классов в динамической памяти.
 * Программа должна содержать меню, позволяющее осуществить проверку всех методов класов.
 * Методы:
 * 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
 * 2. найти из механизмов Plane c высотой полета выше 5000 с годом выпуска после 2000
 * 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
 * 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Size of process list
         */
        final int SIZE = 20;
        /**
         * Output choose list for user
         */
        System.out.println(
                "1) Less Five Years and Min price and Max speed\n" +
                "2) CPlane Height>5000, Year>2000\n" +
                "3) !CPlan 200<Speed<500\n" +
                "4) Sort by Ables");
        /**
         * Open input user choice
         */
        Scanner scn = new Scanner(System.in);
        /**
         * Read from console user input to int variable
         */
        int choose = scn.nextInt();
        /**
         * Close input user choice
         */
        scn.close();
        /**
         * Do that user choice
         */
        switch (choose){
            case 1: {
                /**
                 * Create process list of simple children of CVehicles (CCar, CPlan, CShip)
                 */
                List listSimpleCVehicles = fillSimpleList(SIZE);
                printList(listSimpleCVehicles);
                /**
                 * Create a result list and fill it with the required values
                 */
                List listTaskOne = taskOne(listSimpleCVehicles);
                System.out.println();

                System.out.println("Less Five Years:");
                for (int i = 0; i < listTaskOne.size() - 2; i++) {
                    System.out.println(listTaskOne.get(i));
                }

                System.out.println("Min price:");
                System.out.println(listTaskOne.get(listTaskOne.size() - 2));

                System.out.println("Max speed:");
                System.out.println(listTaskOne.get(listTaskOne.size() - 1));
                break;
            }
            case 2: {
                /**
                 * Create process list of simple children of CVehicles (CCar, CPlan, CShip)
                 */
                List listSimpleCVehicles = fillSimpleList(SIZE);
                printList(listSimpleCVehicles);
                /**
                 * Create a result list and fill it with the required values
                 */
                List listTaskTwo = taskTwo(listSimpleCVehicles);
                System.out.println();

                System.out.println("CPlane Height>5000, Year>2000:");
                printList(listTaskTwo);
                break;
            }
            case 3: {
                /**
                 * Create process list of simple children of CVehicles (CCar, CPlan, CShip)
                 */
                List listSimpleCVehicles = fillSimpleList(SIZE);
                printList(listSimpleCVehicles);
                /**
                 * Create a result list and fill it with the required values
                 */
                List listTaskThree = taskThree(listSimpleCVehicles);
                System.out.println();

                System.out.println("!CPlan 200<Speed<500:");
                printList(listTaskThree);
                break;
            }
            case 4: {
                /**
                 * Create process list of each children of CVehicles (CCar, CPlan, CShip, AmphibiaCar, BetCar)
                 */
                List listEachOfCVehicles = fillEachOfList(SIZE);
                printList(listEachOfCVehicles);
                /**
                 * Create a result list for object implement MoveAble interface
                 */
                List listMove = new LinkedList<CVehicle>();
                /**
                 * Create a result list for object implement FlyAble interface
                 */
                List listFly = new LinkedList<CVehicle>();
                /**
                 * Create a result list for object implement SwimAble interface
                 */
                List listSwim = new LinkedList<CVehicle>();
                /**
                 * Fill the lists with the required values
                 */
                for (int i = 0; i < listEachOfCVehicles.size(); i++) {
                    if (listEachOfCVehicles.get(i) instanceof MoveAble) listMove.add(listEachOfCVehicles.get(i));
                    if (listEachOfCVehicles.get(i) instanceof FlyAble) listFly.add(listEachOfCVehicles.get(i));
                    if (listEachOfCVehicles.get(i) instanceof SwimAble) listSwim.add(listEachOfCVehicles.get(i));
                }

                System.out.println("MoveAble:");
                printList(listMove);

                System.out.println("FlyAble:");
                printList(listFly);

                System.out.println("SwimAble:");
                printList(listSwim);
                break;
            }
            default:
                System.out.println("Not correct input!!!");
        }


    }

    /**
     * Method return all CVehicle objects that aren't plans and have speed more 200 and lass 500
     * @param list - list will processed
     * @return List<CVehicle> - list of CVehicle objects have speed more 200 and lass 500
     */
    public static List<CVehicle> taskThree(List<CVehicle> list){
        /**
         * List will fill and return (CVehicle)
         */
        List res = new LinkedList<CVehicle>();

        for (int i = 0; i < list.size(); i++) {
            if(!(list.get(i) instanceof CPlane)) {
                if (list.get(i).getSpeed() > 200 && list.get(i).getSpeed() < 500) res.add(list.get(i));
            }
        }
        return res;
    }

    /**
     * Method return all CPlane objects have height of fly more 5000 and production year more 2000
     * @param list - list will processed
     * @return List<CPlane> - list of CPlane objects have height of fly more 5000 and production year more 2000
     */
    public static List<CPlane> taskTwo(List<CVehicle> list){
        /**
         * List will fill and return (CPlane)
         */
        List res = new LinkedList<CPlane>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof CPlane) {
                if (list.get(i).getYear() > 2000) {
                    if (((CPlane)list.get(i)).getHeight() > 5000) res.add(list.get(i));
                }
            }
        }
        return res;
    }

    /**
     * Method return:
     * one child of CVehicle has the lowest price,
     * one has highest speed and
     * list of CVehicle children that aren't older 5 years
     * @param list - list will processed
     * @return List<CVehicle> - result list contain all of CVehicle children will be chosen
     */
    public static List<CVehicle> taskOne(List<CVehicle> list){
        /**
         * List will fill and return (CVehicle)
         */
        List res = new LinkedList<CVehicle>();
        /**
         * Variable will contain item has minimum price
         */
        CVehicle minPrice = list.get(0);
        /**
         * Variable will contain item has maximum speed
         */
        CVehicle maxSpeed = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() < minPrice.getPrice()) minPrice = list.get(i);
            if (list.get(i).getYear() > 2012) res.add(list.get(i));
            if (list.get(i).getSpeed() > maxSpeed.getSpeed()) maxSpeed = list.get(i);
        }
        res.add(minPrice);
        res.add(maxSpeed);

        return res;
    }

    /**
     * Print list will received
     * @param list - list will printed
     */
    public static void printList(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    /**
     * Method return list of simple children of CVehicles (CCar, CPlan, CShip) that will create randomly
     * @param size - size of list will created and returned
     * @return List<CVehicle> - list of simple children of CVehicles (CCar, CPlan, CShip) that will create randomly
     */
    public static List<CVehicle> fillSimpleList(int size) {
        /**
         * List will fill and return
         */
        List list  = new LinkedList();

        for (int i = 0; i < size; i++) {
            list.add(RandomCVehicle.randomSimpleOfTypesCVehicle());
        }

        return list;
    }
    /**
     * Method return list of each children of CVehicles (CCar, CPlan, CShip, AmphibiaCar, BetCar) that will create randomly
     * @param size - size of list will created and returned
     * @return List<CVehicle> - list of simple children of CVehicles (CCar, CPlan, CShip) that will create randomly
     */
    public static List<CVehicle> fillEachOfList(int size) {
        /**
         * List will fill and return
         */
        List list  = new LinkedList();

        for (int i = 0; i < size; i++) {
            list.add(RandomCVehicle.randomEachOfTypesCVehicle());
        }

        return list;
    }
}
