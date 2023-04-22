package algorithms.sortings;

public class MergeSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int middle = len / 2;
        if (len < 2)
            return;

        int[] left = new int[middle];
        int[] right = new int[len - middle];

        for (int i = 0; i < middle; ++i)
            left[i] = arr[i];

        for (int i = middle; i < right.length + middle; ++i)
            right[i - middle] = arr[i];

        sort(left);
        sort(right);

        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
