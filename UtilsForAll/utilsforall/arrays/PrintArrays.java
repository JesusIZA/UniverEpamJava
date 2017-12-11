package utilsforall.arrays;
/**
 * Abstract class contain methods for print arrays
 *
 * @author Jesus Raichuk
 */
public abstract class PrintArrays {
    /**
     * Print int array by one row
     * @param array - array will print
     */
    public static final void printIntArrayByOneRow(final int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    /**
     * Print int array by rows
     * @param array - array will print
     */
    public static final void printIntArrayByRows(final int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
