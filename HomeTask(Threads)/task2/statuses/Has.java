package homeWorks.hw7.task2.statuses;

/**
 * Realize process taking box from the ground
 * And putting it to the car
 * And count cost of the all boxes
 *
 * @author Jesus Raichuk
 */
public class Has {
    /**
     * Cost of new box
     */
    public int n;
    /**
     * Sum prices of all boxes
     */
    public static int allPrice = 0;
    /**
     * Is box in the car or not
     */
    public static boolean isInto = false;

    public Has(){

    }

    /**
     * If is the box in the car will take it
     * And add price of one to all sum
     * @return int - prise if the box
     */
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

    /**
     * Take the box from ground if it is there
     * And putting it to the car
     * @param n - price of the box
     */
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
