package homeWorks.hw7.task2.statuses;

/**
 * @author Jesus Raichuk
 */
public class Has {
    private int n;
    public static int allPrice = 0;
    public static boolean isInto = false;

    public Has(){

    }

    public synchronized int count(){
        while(!isInto){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        allPrice += n;
        System.out.println("Add to all cost " + n + " = " + allPrice);
        isInto = false;
        notify();
        return n;
    }

    public synchronized void into(int n){
        while(isInto){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        isInto = true;
        System.out.println("Put into car " + n);
        notify();
    }
}
