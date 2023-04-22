package algorithms.sortings;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 5, 7, 1, 3, 34, 22, 14};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
