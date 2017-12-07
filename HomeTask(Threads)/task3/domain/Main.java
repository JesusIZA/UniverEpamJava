package homeWorks.hw7.task3.domain;

import homeWorks.hw7.task3.entitys.Fight;
import homeWorks.hw7.task3.entitys.Monk;
import utilsforall.lists.PrintLists;

import java.util.ArrayList;
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
    static List<Monk> monks = new ArrayList<Monk>();
    public static void main(String[] args) {

        monks = getListOfMonks(100);

        Fight fight = new Fight(monks);

        int round = 1;

        while(fight.isFight){

            if(fight.monks.size() == 1) {
                System.out.println("\nGiving the prize ");
                new Thread(fight, "Rewarding").start();
            } else {
                System.out.println("\nRound " + round++ + " start");
                for (int i = 0; i < fight.monks.size() / 2; i++) {
                    new Thread(fight, "Fight" + (i + 1)).start();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Monk> getListOfMonks(int size){
        List<Monk> monks = new ArrayList<Monk>();
        for (int i = 0; i < size; i++) {
            monks.add(new Monk("Monk" + i,(int)(1 + Math.random() * size)));
        }
        return monks;
    }

}

