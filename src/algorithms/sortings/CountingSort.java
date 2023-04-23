package algorithms.sortings;

public class CountingSort {
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i)
            if (max < arr[i])
                max = arr[i];
        return max;
    }

    public static void sort(int[] arr) {
        int[] count = new int[getMax(arr) + 1];

        for (int i : arr)
            count[i]++;

        for (int i = 0, j = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }
        }
    }
}
