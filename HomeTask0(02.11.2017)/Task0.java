package epam.hw0;

public class Task0 {
    public static void main(String[] args) {
        {
            //Прямокутник
            int n = 5, m = 10;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i == 0 || j == 0 || i == n || j == m) {
                        System.out.print("* ");// * та пропуск
                    } else {
                        System.out.print("  ");// 2 пропуски
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        {
            //Прямокутний трикутник
            int m = 10;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i == m || j == 0 || i == j) {
                        System.out.print("* ");// * та пропуск
                    } else {
                        System.out.print("  ");// 2 пропуски
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        {
            //Рівносторонній трикутник
            int m = 5;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= m * 2; j++) {
                    if (j == m - i || j == m + i || i == m) {
                        System.out.print("* ");// * та пропуск
                    } else {
                        System.out.print("  ");// 2 пропуски
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        {
            //Ромб
            int m = 10;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= m; j++) {
                    if (j == m / 2 + i || j == i - m / 2 || j == m / 2 - i || j == m - i + m / 2) {
                        System.out.print("* ");// * та пропуск
                    } else {
                        System.out.print("  ");// 2 пропуски
                    }
                }
                System.out.println();
            }
        }


    }
}
