package homeWorks.hw7.task2.entitys;

import homeWorks.hw7.task2.statuses.Take;

/**
 * Person will take the box from warehouse
 *
 * @author Jesus Raichuk
 */
public class TakerFromStorage implements Runnable{
    /**
     * Box from warehouse to the ground
     */
    Take good;

    public TakerFromStorage(Take g){
        this.good = g;
        new Thread(this, "Taker From Storage").start();
    }

    /**
     * Take the box from warehouse
     * And putting box on the ground
     */
    @Override
    public void run() {
        int i = 10;
        while(true){
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            good.put(i + (int) (Math.random() * 10));
        }
    }
}
