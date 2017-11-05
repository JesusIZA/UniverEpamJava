package epam.hw1;

/**
 * Дана целочисленная прямоугольная матрица.
 * 3. Упорядочить столбцы по убыванию среднего значения.
 *
 * @author Jesus Raichuk
 */
public class Task3 {
    /**
     * Print each value of int[][] array
     * @param M - array will be printed (must be int type)
     */
    public static void printM(int[][] M){
        for (int i = 0; i < M.length; i++) {
            Task1.printM(M[i]);
        }
    }
    public static void main(String[] args) {
        /**
         * Size of array will process
         */
        int n = 7;
        /**
         * Array will process
         */
        int[][] M = new int[n][n];
        /*
         * Filling array M random values
         */
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = (int)(Math.random() * 10);
            }
        }
        System.out.println("M:");
        printM(M);

        /**
         * Array will contain average value for each column
         */
        int[] averageM = new int[n];
        /**
         * Finding the average value for each column
         */
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                averageM[i] += M[j][i];
            }
            averageM[i] /= n;
        }
        System.out.println("Averages:");
        Task1.printM(averageM);

        /**
         * Sorting array of average values and columns in array M (processing)
         */
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length - i - 1; j++) {
                if(averageM[j] < averageM[j+1]) {
                    int temp = averageM[j];
                    int[] tempM = new int[n];
                    for (int k = 0; k < n; k++) {
                        tempM[k] = M[k][j];
                    }
                    averageM[j] = averageM[j + 1];
                    for (int k = 0; k < n; k++) {
                        M[k][j] = M[k][j + 1];
                    }
                    averageM[j + 1] = temp;
                    for (int k = 0; k < n; k++) {
                        M[k][j + 1] = tempM[k];
                    }
                }
            }
        }

        System.out.println("Processed:\nAverages:");
        Task1.printM(averageM);
        System.out.println("M:");
        printM(M);
    }
}
