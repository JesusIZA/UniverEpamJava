package epam.hw1;

/**
 * Дана целочисленная прямоугольная матрица.
 * 5. Дана квадратная матрица A порядка M (M — нечетное число).
 * Начиная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее элементы по спирали:
 * первая строка, последний столбец, последняя строка в обратном  порядке,  первый  столбец  в  обратном  порядке,
 * оставшиеся  элементы второй строки и т. д.; последним выводится центральный элемент матрицы.
 *
 * @author Jesus Raichuk
 */
public class Task5 {
    public static void main(String[] args) {
        /**
         * Size of array will process (N % 2 =1)
         */
        int n = 7;
        /**
         * Array will process
         */
        int[][] A = new int[n][n];
        /*
         * Filling array A random values
         */
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = (int)(Math.random() * 10);
            }
        }
        
        System.out.println("A:");
        Task3.printM(A);

        System.out.println("By spiral:");
        /**
         * Output items by spiral
         */
        for (int i = 0; i < A.length; i++) {
            for (int k = i; k < A[i].length - i - 1; k++) {
                System.out.print(A[i][k]);
            }
            for (int l = i; l < A[i].length - i - 1; l++) {
                System.out.print(A[l][A[i].length - i - 1]);
            }
            for (int j = A[i].length - i - 1; j > i; j--) {
                System.out.print(A[A[i].length - i - 1][j]);
            }
            for (int h = A[i].length - i - 1; h > i; h--) {
                System.out.print(A[h][i]);
            }

        }
        /**
         * if n % 2 == 1 output center element
         */
        if(n % 2 == 1) System.out.print(A[n/2][n/2]);

    }
}
