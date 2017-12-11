package homeWorks.hw7.task3.entitys;

import java.util.LinkedList;
import java.util.List;

/**
 * Arena for fighting
 *
 * @author Jesus Raichuk
 */
public class Arena {
    /**
     * Wonk will fight
     */
    public static List<Monk> monks;
    /**
     * Winners monks
     */
    public static List<Monk> winners;
    /**
     * Has one winner or not
     */
    public static boolean isWinner = false;

    public Arena(List<Monk> monks) {
        this.monks = new LinkedList<Monk>();
        this.winners = new LinkedList<Monk>();
        for (int i = 0; i < monks.size(); i++) {
            this.monks.add(monks.get(i));
        }
    }

    /**
     * Getting two monks for fight
     * @param start - first of these monks
     * @return list - two monks will fight
     */
    public List getOneTeamForFight(int start) {
        List temp = new LinkedList();
        int i = start;
        while (i < this.monks.size() && i < (start + 2)) {
            temp.add(this.monks.get(i));
            i++;
        }
        return temp;
    }
}