package epam.hw1;

/**
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n)
 *
 * @author Jesus Raichuk
 */
public class Task2 {
    /**
     * Putting positive value into begin of the array and negative into end one
     * @param M - array will be processed (must be int type)
     * @return newM - array of int (processed)
     */
    public static int[] positiveThenNegative(int[] M){
        /**
         * Array will contain processing values of array M (input)
         * One will be returned
         */
        int[] newM = new int[M.length];

        int i = 0, neg = newM.length -1, pos = 0;
        /*
         * O(n)
         */
        while (i < M.length) {
            if(M[i] < 0) {
                newM[neg] = M[i];
                neg--;
            } else {
                newM[pos] = M[i];
                pos++;
            }
            i++;
        }
        return newM;
    }
    public static void main(String[] args) {
        /**
         * Size of array will process
         */
        final int N = 20;
        /**
         * Array will process
         */
        int[] M = new int[N];

        /*
         * Filling array M random values
         */
        for (int i = 0; i < M.length; i++) {
            M[i] = (int)((Math.random() * 100) - 50);
        }

        Task1.printM(M);

        M = positiveThenNegative(M);

        Task1.printM(M);
    }
}
