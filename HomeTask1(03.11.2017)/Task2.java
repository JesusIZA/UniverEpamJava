package epam.hw1;

/**
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n)
 *
 * @author Jesus Raichuk
 */
public class Task2 {

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

        /**
         * 'i' and 'j' - counter will move to each other
         */
        int i = 0, j = M.length - 1;
        /**
         *Sorting array M
         */
        while(i < j){
            if(M[i] < 0){
                if(M[j] >= 0){
                    int temp = M[j];
                    M[j] = M[i];
                    M[i] = temp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }

        Task1.printM(M);
    }
}
