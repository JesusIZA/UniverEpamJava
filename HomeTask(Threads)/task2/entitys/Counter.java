package homeWorks.hw7.task2.entitys;

import homeWorks.hw7.task2.statuses.Has;
import homeWorks.hw7.task2.statuses.Take;

/**
 * Person will count sum of price all boxes
 *
 * @author Jesus Raichuk
 */
public class Counter implements Runnable {
    /**
     * Box in the car
     */
    Has good;

    public Counter(Has g){
        this.good = g;
        new Thread(this, "Counter ").start();
    }

    /**
     * Adding price of the box to all sum
     */
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            good.count();
        }
    }
}
