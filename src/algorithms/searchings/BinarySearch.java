package algorithms.searchings;

public class BinarySearch {
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

    private static int searchLoop(int[] arr, int item) {
        int left = 0;
        int right = arr.length - 1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (item == arr[middle])
                return middle;
            if (item < arr[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public static int search(int[] arr, int item) {
        return search(arr, item, 0, arr.length - 1);
//        return searchLoop(arr, item);
    }
}
