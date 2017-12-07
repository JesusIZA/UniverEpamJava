package homeWorks.hw7.task2.entitys;

import homeWorks.hw7.task2.statuses.Has;
import homeWorks.hw7.task2.statuses.Take;

/**
 * @author Jesus Raichuk
 */
public class Counter implements Runnable {
    Has good;

    public Counter(Has g){
        this.good = g;
        new Thread(this, "Counter ").start();
    }

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
