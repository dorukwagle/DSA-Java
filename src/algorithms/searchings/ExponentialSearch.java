package algorithms.searchings;

public class ExponentialSearch {
    public static int search(int[] arr, int item) {
        int bound = 1;
        while (bound < arr.length && arr[bound] < item)
            bound *= 2;
        if (bound >= arr.length)
            bound = arr.length - 1;

        return search(arr, item, bound / 2, bound);
    }

    private static int search(int[] arr, int item, int left, int right) {
        if (left > right)
            return -1;

        int middle = (left + right) / 2;

        if (arr[middle] == item)
            return middle;

        if (item < arr[middle])
            return search(arr, item, left, middle - 1);
        return search(arr, item, middle + 1, right);
    }
}
