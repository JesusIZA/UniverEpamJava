package homeWorks.hw7.task3.domain;

import homeWorks.hw7.task3.entitys.Arena;
import homeWorks.hw7.task3.entitys.Fight;
import homeWorks.hw7.task3.entitys.Monk;
import utilsforall.lists.PrintLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Тема: многопоточность.
 * с) Задача о Пути Кулака.
 * На седых склонах Гималаев стоят два древних буддистских монастыря:
 * Гуань-Инь и Гуань-Янь. Каждый год в день сошествия на землю боддисатвы Араватти
 * монахи обоих монастырей собираются на совместное празднество и показывают свое совершенствование на Пути Кулака.
 * Всех соревнующихся монахов разбивают на пары, победители пар бьются затем между собой и так далее, до финального поединка.
 * Монастырь, монах которого победил в финальном бою, забирает себе на хранение статую боддисатвы.
 * Реализовать многопоточное приложение, определяющего победителя.
 * В качестве входных данных используется массив, в котором хранится количество энергии Ци каждого монаха.
 * При решении использовать принцип дихотомии.
 *
 * @author Jesus Raichuk
 */
public class Main {
    /**
     * List of all monks will fight
     */
    static List<Monk> monks = new ArrayList<Monk>();

    public static void main(String[] args) throws InterruptedException {
        /**
         * Fill the list of monks random monks
         */
        monks = getListOfMonks(100);
        /**
         * Create arena where monks will fight
         */
        Arena arena = new Arena(monks);
        /**
         * Start fighting
         */
        int round = 0;
        while(!arena.isWinner){
            PrintLists.printListByOneRow(arena.monks);
            if(arena.monks.size() <= 1) {
                arena.isWinner = true;
            } else {
                System.out.println("\n\nRound " + round++ + " start");
                for (int i = 0; i < arena.monks.size(); i+=2) {
                    Thread t = new Thread(new Fight(arena, arena.getOneTeamForFight(i)), "Fight" + i/2);
                    t.start();
                    t.join();
                }
                arena.monks = new LinkedList(arena.winners);
                arena.winners = new LinkedList<Monk>();
            }
        }
        System.out.println("\nWINNER is " + arena.monks.get(0));

    }
    /**
     * Fill the list of monks random monks
     */
    private static List<Monk> getListOfMonks(int size){
        List<Monk> monks = new ArrayList<Monk>();
        for (int i = 0; i < size; i++) {
            monks.add(new Monk("Monk" + i,(int)(1 + Math.random() * size)));
        }
        return monks;
    }

}

