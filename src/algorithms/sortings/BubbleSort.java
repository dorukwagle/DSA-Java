package algorithms.sortings;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if ( array[j] < array[j - 1] ) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void sortOptim(int[] array) {
        boolean isSorted = false;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - 1; j++) {
                if ( array[j] < array[j - 1] ) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

}
