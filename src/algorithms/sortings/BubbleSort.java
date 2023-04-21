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

    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 5, 7, 1, 3, 34, 22, 14};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
