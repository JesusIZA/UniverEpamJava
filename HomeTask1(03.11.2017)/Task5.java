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
    /**
     * Output items of square matrix by spiral
     * @param A - matrix (must be int[][])
     */
    public static void OutBySpiral(int[][] A) {
        /**
         * Quantity of rows of the array will process
         */
        final int N = A.length;
        /**
         * Quantity of columns of the array will process
         */
        final int M = A[0].length;
        /**
         * If Array contain only one row or column
         */
        if(N == 1) {
            Task1.printM(A[0]);
        } else if (M == 1){
            for (int i = 0; i < N; i++) {
                System.out.print(A[i][0] + " ");
            }
        }
        /**
         * If array contain more than one row or column
         */
        else {
            /**
             * Quantity of items in the array A
             */
            int count = 0;

            int i =0;
            /**
             * Output items by spiral
             */
            while(count < N * M) {
                for (int k = i; k < M - i - 1; k++) {
                    if(count == N * M) break;
                    System.out.print(A[i][k]);
                    count++;
                }
                for (int l = i; l < N - i - 1; l++) {
                    if(count == N * M) break;
                    System.out.print(A[l][M - i - 1]);
                    count++;
                }
                for (int j = M - i - 1; j > i; j--) {
                    if(count == N * M) break;
                    System.out.print(A[N - i - 1][j]);
                    count++;
                }
                for (int h = N - i - 1; h > i; h--) {
                    if(count == N * M) break;
                    System.out.print(A[h][i]);
                    count++;
                }
                i++;
                if(M % 2 == 1 && N % 2 == 1 && count == N * M - 1){
                    count++;
                    System.out.println(A[N/2][M/2]);
                }
            }
        }

    }

    public static void main(String[] args) {
        /**
         * Quantity of rows of the array will process (N % 2 =1)
         */
        final int N = 7;
        /**
         * Quantity of columns of the array will process (M % 2 =1)
         */
        final int M = 5;
        /**
         * Array will process
         */
        int[][] A = new int[N][M];
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
        OutBySpiral(A);
    }
}
