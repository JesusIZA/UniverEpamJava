package homeWorks.hw7.task1.entitys;

import utilsforall.lists.PrintLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Realize Bee searcher for Wini
 *
 * @author Jesus Raichuk
 */
public class Bee implements Runnable {
    /**
     * Part of forest the Bee will search
     */
    List<Integer> square;
    /**
     * Is bee at alveary or not
     */
    public boolean atAlveary = true;
    /**
     * Wini
     */
    Wini w;

    public Bee(Wini found) {
        square = new ArrayList();
        w = found;
    }

    public void setSquare(List square) {
        this.square = square;
    }

    /**
     * Search for Wini
     */
    @Override
    public void run() {
        /**
         * if Wini is not found
         */
        if(!w.isFound()) {
            /**
             * Bee go from alveary
             */
            atAlveary = false;
            System.out.println();

            PrintLists.printListByOneRow(square);
            System.out.println(" " + Thread.currentThread().getName() + " go");
            try {
                Thread.sleep(1000 + (int) (Math.random() * 1000));
            } catch (Exception e) {
            }
            /**
             * Bee will find or not
             */
            boolean temp = false;
            /**
             * Look for Wini
             */
            for (int i : square) {
                if (i == 1) {
                    temp = true;
                    break;
                }
            }

            try {
                Thread.sleep(1000 + (int) (Math.random() * 1000));
            } catch (Exception e) {
            }
            System.out.println("\n" + Thread.currentThread().getName() + " came");
            /**
             * Say result for all Bees
             */
            w.setFound(temp);
            if (w.isFound()) System.out.println("Found");
            /**
             * Bee come back to alveary
             */
            atAlveary = true;
        }
    }
}
