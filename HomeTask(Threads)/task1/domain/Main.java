package homeWorks.hw7.task1.domain;

import homeWorks.hw7.task1.entitys.Bees;

import java.util.LinkedList;
import java.util.List;

/**
 * Тема: многопоточность.
 * а)Первая задача о Винни-Пухе, или неправильные пчелы.
 * Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха,
 * решили разыскать его и наказать в назидание всем другим любителям сладкого.
 * Для поисков медведя они поделили лес на участки, каждый из которых прочесывает одна стая неправильных пчел.
 * В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
 * Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
 * Требуется создать многопоточное приложение, моделирующее действия пчел.
 * При решении использовать парадигму портфеля задач.
 *
 * @author Jesus Raichuk
 */
public class Main {
    static final int SIZE = 30;
    static final int STEP = 5;
    static int[][] forest = new int[SIZE][SIZE];
    public static void main(String[] args){

        fillTheForest();

        List f1 = getForestSquare(0, SIZE * SIZE / 4);
        List f2 = getForestSquare(SIZE * SIZE / 4, SIZE * SIZE / 4);
        List f3 = getForestSquare(SIZE * SIZE / 4 * 2, SIZE * SIZE / 4);
        List f4 = getForestSquare(SIZE * SIZE / 4 * 3, SIZE * SIZE / 4);

        Bees bee1 = new Bees(f1, STEP);
        Bees bee2 = new Bees(f2, STEP);
        Bees bee3 = new Bees(f3, STEP);
        Bees bee4 = new Bees(f4, STEP);

        Thread bees1 = new Thread(bee1);
        Thread bees2 = new Thread(bee2);
        Thread bees3 = new Thread(bee3);
        Thread bees4 = new Thread(bee4);

        bees1.setName("One bee swarm");
        bees2.setName("Two bee swarm");
        bees3.setName("Three bee swarm");
        bees4.setName("Four bee swarm");

        bees1.start();
        bees2.start();
        bees3.start();
        bees4.start();

    }

    private static void fillTheForest(){
        int winiX = (int) (Math.random()*SIZE);
        int winiY = (int) (Math.random()*SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == winiX && j == winiY)
                    forest[i][j] = 1;
                else
                    forest[i][j] = 0;
            }
        }
    }
    public static List forestIntoList(){
        List temp = new LinkedList();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                temp.add(forest[i][j]);
            }
        }
        return temp;
    }
    public static List getForestSquare(int start, int square){
        List f = forestIntoList();
        List temp = new LinkedList();
        int i = start;
        while(i < f.size() && i < start + square){
            temp.add(f.get(i));
            i++;
        }
        return temp;
    }


}

