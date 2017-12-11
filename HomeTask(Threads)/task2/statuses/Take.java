package homeWorks.hw7.task2.statuses;

/**
 * Realize process taking box from the warehouse
 * And putting it on the ground
 *
 * @author Jesus Raichuk
 */
public class Take {
    /**
     * Cost of new box
     */
    public int n;
    /**
     * Is box on the ground or not
     */
    public static boolean isPut = false;

    public Take(){
    }
    /**
     * If is the box on the ground will take it
     * @return int - prise if the box
     */
    public synchronized int take(){
        while(!isPut){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Took from a ground " + n);
        isPut = false;
        notify();
        return n;
    }
    /**
     * Take the box from warehouse
     * And putting it on the ground
     * @param n - price of the box
     */
    public synchronized void  put(int n){
        while(isPut){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        isPut = true;
        System.out.println("Put on a ground " + n);
        notify();
    }

}
