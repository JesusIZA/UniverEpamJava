package homeWorks.hw7.task2.entitys;

import homeWorks.hw7.task2.statuses.Take;

/**
 * @author Jesus Raichuk
 */
public class TakerFromStorage implements Runnable{
    Take good;

    public TakerFromStorage(Take g){
        this.good = g;
        new Thread(this, "Taker From Storage").start();
    }

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
