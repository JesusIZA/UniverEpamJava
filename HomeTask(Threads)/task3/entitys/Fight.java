package homeWorks.hw7.task3.entitys;

import utilsforall.lists.PrintLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Class realize fight
 *
 * @author Jesus Raichuk
 */
public class Fight implements Runnable{
    /**
     * Arena
     */
    Arena arena;
    /**
     * Two monks will fight
     */
    List<Monk> team;

    public Fight(Arena arena, List<Monk> team) {
        this.arena = arena;
        this.team = team;
    }

    /**
     * Begin fight
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if(team.size() == 2){
            if (team.get(0).getPower() >= team.get(1).getPower()) {
                arena.winners.add(team.get(0));
            } else {
                arena.winners.add(team.get(1));
            }

        } else {
            arena.winners.add(team.get(0));
        }
    }
}
