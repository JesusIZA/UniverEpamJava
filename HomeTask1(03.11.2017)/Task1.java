package epam.hw1;

/**
 * 1. Упорядочить одномерный масиве вначале отрицательные по возрастанию затем положительные по убыванию.
 *
 * @author Jesus Raichuk
 */
public class Task1 {
    /**
     * Print each value of int[] array
     * @param M - array will be printed (must be int type)
     */
    public static void printM(int[] M){
        for (int i : M) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Revers int array
     * @param M - array will be reversed (must be int type)
     * @return tempM - array of int (reversed)
     */
    public static int[] reversM(int[] M) {
        /**
         * New int array with length equals M.length, this one will be saving reversed array M
         * And one will returned
         */
        int[] tempM = new int[M.length];
        for(int i = M.length - 1, j = 0; i >= 0; i--, j++) {
            tempM[j] = M[i];
        }
        return tempM;
    }

    public static void main(String[] args) {
        /**
         * Size of array will process
         */
        int n = 20;
        /**
         * Array will process
         */
        int[] M = new int[n];

        /*
         * Filling array M random values
         */
        for (int i = 0; i < M.length; i++) {
            M[i] = (int)((Math.random() * 100) - 50);
        }

        printM(M);

        /*
         * Sorting negative values
         */
        for(int i = 0; i < M.length - 1; i++) {
           for(int j = 0; j < M.length - i - 1; j++) {
               if(M[j] < 0 && M[j] < M[j+1]) {
                   int temp = M[j];
                   M[j] = M[j+1];
                   M[j+1] = temp;
               }
           }
        }

        printM(M);

        /*
         * Sorting positive values
         */
        int i = 0;
        while(M[i] >= 0 && i < M.length - 1) {
            int j = 0;
            while(M[j + 1] >= 0 && j < M.length - 2) {
                if(M[j] >= 0 && M[j] > M[j+1]) {
                    int temp = M[j];
                    M[j] = M[j+1];
                    M[j+1] = temp;
                }
                j++;
            }
            i++;
        }

        printM(M);

        M = reversM(M);

        printM(M);
    }
}
