package homeWorks.hw7.task3.entitys;

import utilsforall.lists.PrintLists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesus Raichuk
 */
public class Fight implements Runnable{
    public static List<Monk> monks;
    public static boolean isFight = true;

    public Fight(List list) {
        List m = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            m.add(list.get(i));
        }
        monks = m;
    }

    @Override
    public void run() {
        synchronized (monks) {
            System.out.println(Thread.currentThread().getName());
            if (monks.size() > 1 && isFight) {
                if (monks.get(0).getPower() >= monks.get(1).getPower())
                    monks.remove(1);
                else
                    monks.remove(0);
                System.out.println("List of monks after the fight:");
                PrintLists.printListByOneRow(monks);
            } else {
                isFight = false;
                System.out.println(monks.get(0).getName() + " TAKE THE STATUE!!!");
            }
            System.out.println();
        }

    }
}
