package algorithms.sortings;

public class QuickSort {

    private static void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int boundary = partition(arr, start, end);

        sort(arr, start, boundary - 1);
        sort(arr, boundary + 1, end);

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;

        for (int i = start; i <= end; ++i)
            if (arr[i] <= pivot)
                swap(arr, ++boundary, i);

//        swap(arr, ++boundary, end);

        return boundary;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
}
