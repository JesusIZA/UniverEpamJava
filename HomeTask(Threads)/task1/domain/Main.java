package homeWorks.hw7.task1.domain;

import homeWorks.hw7.task1.entitys.Bee;
import homeWorks.hw7.task1.entitys.Wini;
import utilsforall.lists.PrintLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Тема: многопоточность.
 * а)Первая задача о Винни-Пухе, или неправильные пчелы.
 * Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха,
 * решили разыскать его и наказать в назидание всем другим любителям сладкого.
 * Для поисков медведя они поделили лес на участки, каждый из которых прочесывает одна стая неправильных пчел.
 * В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
 * Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
 * Требуется создать многопоточное приложение, моделирующее действия пчел.
 * При решении использовать парадигму портфеля задач.
 *
 * @author Jesus Raichuk
 */
public class Main {
    /**
     * Size of forest
     */
    static final int SIZE = 7;
    /**
     * Step Bee will look for Wini
     */
    static final int STEP = 3;
    /**
     * Forest
     */
    static int[][] forest = new int[SIZE][SIZE];

    public static void main(String[] args) throws InterruptedException {
        /**
         * Fill the forest
         */
        fillTheForest();
        /**
         * Convert forest to list
         */
        List<Integer> frst = forestIntoList();

        PrintLists.printListByOneRow(frst);
        /**
         * Create Wini
         */
        Wini wini = new Wini();
        /**
         * Create Bee 1 and set Wini
         */
        Bee b1 = new Bee(wini);
        /**
         * Create Bee 2 and set Wini
         */
        Bee b2 = new Bee(wini);
        /**
         * Create Bee 3 and set Wini
         */
        Bee b3 = new Bee(wini);

        /**
         * Looking for Wini
         */
        int i = 0;
        while(!wini.isFound()){
            Thread.sleep(100);
            /**
             * Next part of forest need to process
             */
            List<Integer> l = new ArrayList<Integer>();
            /**
             * Take the pert of forest
             */
            for (int j = i; j < frst.size() && j < i + STEP; j++) {
                l.add(frst.get(j));
            }
            /**
             * Give task for free bee if we have the task
             */
            if(l.size() > 0) {
                System.out.print("\nTask = ");
                PrintLists.printListByOneRow(l);
                /**
                 * Took the task or not
                 */
                boolean took = false;
                /**
                 * Give task for free bee
                 */
                while (!took && !wini.isFound()) {
                    if (b1.atAlveary) {
                        b1.setSquare(l);
                        took = true;
                        new Thread(b1, "Bee1").start();
                    } else if (b2.atAlveary) {
                        b2.setSquare(l);
                        took = true;
                        new Thread(b2, "Bee2").start();
                    } else if (b3.atAlveary) {
                        b3.setSquare(l);
                        took = true;
                        new Thread(b3, "Bee3").start();
                    }
                    Thread.sleep(100);
                }
            }
            else
                break;
            i += STEP;
            Thread.sleep(500);
        }

    }

    /**
     * Convert int[][] to list of forest
     * @return list - forest
     */
    private static List forestIntoList() {
        List temp = new ArrayList<Integer>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                temp.add(forest[i][j]);
            }
        }
        return temp;
    }

    /**
     * Fill the forest
     * And add wini in random position
     */
    public static void fillTheForest() {
        int x = (int)(Math.random() * SIZE);
        int y = (int)(Math.random() * SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == x && j == y){
                    forest[i][j] = 1;
                } else {
                    forest[i][j] = 0;
                }
            }
        }
    }

}

