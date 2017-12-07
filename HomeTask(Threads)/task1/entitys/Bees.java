package homeWorks.hw7.task1.entitys;

import java.util.LinkedList;
import java.util.List;

public class Bees implements Runnable{
    private List<Integer> forest;
    private List<Integer> square;
    private int STEP;
    public static boolean find = false;
    public static int visited = 0;

    public Bees(List forest, int STEP){
        List f = new LinkedList();
        for (int i = 0; i < forest.size(); i++) {
            f.add(forest.get(i));
        }
        this.forest = f;
        this.STEP = STEP;
    }

    @Override
    public void run() {
        while (forest.size() > 0 && !find) {
            square = new LinkedList<Integer>();
            for (int i = 0; i < STEP && i < forest.size(); i++) {
                square.add(forest.get(0));
                forest.remove(0);
            }
            System.out.println(Thread.currentThread().getName() + " is looking for Wini");
            visited+=STEP;
            for (int i = 0; i < square.size(); i++) {
                try {
                    Thread.sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (square.get(i) == 1) {
                    System.out.println(Thread.currentThread().getName() + " find and pushed Wini... And Wini understood him mistakes!");
                    find = true;
                    System.out.println("Visited squares: " + visited);
                }
            }
        }
    }

}
