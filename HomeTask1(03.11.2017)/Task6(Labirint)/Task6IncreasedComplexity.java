package epam.hw1.tasc6labirint;

/**
 * Составить программу, отыскивающую проход по лабиринту.
 * Лабиринт представляется в виде матрици, состоящей из квадратов.
 * Каждый квадрат либо открит, либо закрыт.
 * Вход в закрытый квадрат запрещен.
 * Если квадрат открыт, то вход в него возможен со стороны, но не с угла.
 * Каждый квадрат определяктся его координатами в матрице.
 * Программа находит проход через лабиринт, двигаясь от заданого входа.
 * После отыскания прохода программа выводит найденый путь в виде координат квадратов.
 * Для хранения пути использовать стек.
 *
 * @author Jesus Raichuk
 */
public class Task6IncreasedComplexity {
    public static String[][] generateMap(){
        final int N = 10;
        final int M = 15;
        String[][] map = {
                {"0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 "},
                {"0 ","  ","  ","  ","  ","  ","0 ","  ","0 ","0 ","  ","  ","  ","  ","0 "},
                {"0 ","  ","0 ","0 ","  ","0 ","0 ","  ","0 ","0 ","  ","0 ","  ","0 ","0 "},
                {"0 ","  ","0 ","0 ","  ","0 ","0 ","  ","0 ","  ","  ","0 ","  ","0 ","0 "},
                {"0 ","  ","  ","  ","  ","  ","  ","  ","0 ","  ","  ","0 ","  ","0 ","0 "},
                {"0 ","  ","0 ","0 ","  ","0 ","  ","0 ","0 ","0 ","  ","0 ","0 ","0 ","0 "},
                {"0 ","  ","0 ","0 ","0 ","0 ","  ","0 ","0 ","0 ","  ","  ","  ","  ","0 "},
                {"0 ","  ","  ","  ","0 ","  ","  ","  ","  ","0 ","  ","0 ","0 ","  ","0 "},
                {"0 ","0 ","0 ","  ","  ","  ","0 ","0 ","  ","  ","  ","0 ","0 ","  ","0 "},
                {"0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","0 ","F ","0 "}
        };
        return map;
    }
    public static void oneStep(String[][] map, Coordinates2D from, Coordinates2D to){
        map[from.Y()][from.X()] = "  ";
        map[to.Y()][to.X()] = "M ";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] map = generateMap();
        Stack way = new Stack();

        Coordinates2D me = new Coordinates2D(1, 1);
        oneStep(map, new Coordinates2D(1,1), me);
        way.add(new Coordinates2D(0,0));
        way.add(me);
        way.print();

        int flag = 0;
        while(!map[me.Y() + 1][me.X()].equals("F ")) {
            if(map[me.Y()][me.X() + 1].equals("  ")) {
                if(new Coordinates2D(me.Y(), me.X() + 1).equals(way.getP())) {
                    flag += 1;
                } else {
                    oneStep(map, me, me = new Coordinates2D(me.Y(), me.X() + 1));
                    way.add(me);
                    way.print();
                    flag = 0;
                    continue;
                }
            }
            if(map[me.Y() + 1][me.X()].equals("  ")) {
                if(new Coordinates2D(me.Y() + 1, me.X()).equals(way.getP())) {
                    flag += 1;
                } else {
                    oneStep(map, me, me = new Coordinates2D(me.Y() + 1, me.X()));
                    way.add(me);
                    way.print();
                    flag = 0;
                    continue;
                }
            }
            if(map[me.Y()][me.X() - 1].equals("  ")) {
                if(new Coordinates2D(me.Y(), me.X() - 1).equals(way.getP())) {
                    flag += 1;
                } else {
                    oneStep(map, me, me = new Coordinates2D(me.Y(), me.X() - 1));
                    way.add(me);
                    way.print();
                    flag = 0;
                    continue;
                }
            }
            if(map[me.Y() - 1][me.X()].equals("  ")) {
                if(new Coordinates2D(me.Y() - 1, me.X()).equals(way.getP())) {
                    flag += 1;
                } else {
                    oneStep(map, me, me = new Coordinates2D(me.Y() - 1, me.X()));
                    way.add(me);
                    way.print();
                    flag = 0;
                    continue;
                }
            }
            if(flag > 1) {
                way.del();
                Coordinates2D temp = me;
                oneStep(map, me, me = way.get());
                map[temp.Y()][temp.X()] = "# ";
                flag = 0;
                way.print();
            }
        }

    }
}
