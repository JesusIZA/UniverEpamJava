package epam.hw1;

/**
 * Дана целочисленная прямоугольная матрица.
 * 4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 *
 * @author Jesus Raichuk
 */
public class Task4 {
    public static void main(String[] args) {
        /**
         * Size of array will process
         */
        final int N = 10;
        /**
         * Array will process
         */
        int[][] M = new int[N][N];
        /*
         * Filling array M random values
         */
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = (int)(Math.random() * 3);
            }
        }

        System.out.println("M:");
        Task3.printM(M);

        /**
         * The array will contain the lengths of the longest series of identical digits for each row
         */
        int[] lenM = new int[N];
        /**
         * Counting the lengths of the longest series of identical digits for each row
         */
        for (int i = 0; i < M.length; i++) {
            /**
             * Max of length of series in row
             */
            int max = 1;
            /**
             * Variable for count length of series in row
             */
            int count = 1;
            /**
             * Number that will compare with next
             */
            int number = M[i][0];

            for (int j = 1; j < M[i].length; j++) {
                if(M[i][j] == number){
                    count += 1;
                    if(max < count) max = count;
                } else {
                    count = 1;
                    number = M[i][j];
                }
            }
            lenM[i] = max;
        }

        System.out.println("LenM:");
        Task1.printM(lenM);

        /**
         * Sorting array of lengths values of the longest series and rows in array M (processing)
         */
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length - i - 1; j++) {
                if(lenM[j] > lenM[j+1]) {
                    int temp = lenM[j];
                    int[] tempM = M[j];
                    lenM[j] = lenM[j + 1];
                    M[j] = M[j + 1];
                    lenM[j + 1] = temp;
                    M[j + 1] = tempM;
                }
            }
        }

        System.out.println("Processed:\nLenM:");
        Task1.printM(lenM);
        System.out.println("M:");
        Task3.printM(M);
    }
}
