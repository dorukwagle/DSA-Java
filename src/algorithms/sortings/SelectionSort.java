package algorithms.sortings;

public class SelectionSort {
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                if (arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
