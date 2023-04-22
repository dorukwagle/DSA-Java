package algorithms.sortings;

public class InsertionSort {
    public static void sort(int[] arr) {
         for (int i = 1; i < arr.length; ++i)
             insert(arr, i);
    }

    private static void insert(int[] arr, int ind) {
        int current = arr[ind];
        while (ind > 0 && current < arr[ind - 1]) {
            arr[ind] = arr[ind - 1];
            --ind;
        }
        arr[ind] = current;
    }
}
