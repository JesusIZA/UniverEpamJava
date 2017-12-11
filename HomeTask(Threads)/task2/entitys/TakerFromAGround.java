package homeWorks.hw7.task2.entitys;

import homeWorks.hw7.task2.statuses.Has;
import homeWorks.hw7.task2.statuses.Take;

/**
 * Person will take the box from ground and put it to the car
 *
 * @author Jesus Raichuk
 */
public class TakerFromAGround implements Runnable {
    /**
     * Box from the ground
     */
    Take good;
    /**
     * Box into the car
     */
    Has good2;

    public TakerFromAGround(Take g, Has h){
        this.good = g;
        this.good2 = h;
        new Thread(this, "Taker From A Ground And Put into Car").start();
    }

    /**
     * Putting the box to the car
     */
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            good2.into(good.take());
        }
    }
}
