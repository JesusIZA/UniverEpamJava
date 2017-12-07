package homeWorks.hw7.task2.statuses;

/**
 * @author Jesus Raichuk
 */
public class Take {
    private int n;
    public static boolean isPut = false;

    public Take(){
    }

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
