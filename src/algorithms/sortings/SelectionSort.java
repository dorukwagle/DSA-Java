package algorithms.sortings;

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int  i = 0; i < arr.length; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
