package algorithms.searchings;

public class TernarySearch {

    private static int search(int[] arr, int item, int left, int right) {
        if (left > right)
            return -1;

        int firstMiddle = left + (right - left) / 3;
        int secondMiddle = right - (right - left) / 3;

        if (item == arr[firstMiddle])
            return firstMiddle;
        if (item == arr[secondMiddle])
            return secondMiddle;

        int newLeft = left, newRight = right;
        if (item < arr[firstMiddle])
            newRight = firstMiddle - 1;
        else if (item > arr[secondMiddle])
            newLeft = secondMiddle + 1;
        else {
            newLeft = firstMiddle + 1;
            newRight = secondMiddle - 1;
        }
        return search(arr, item, newLeft, newRight);
    }

    public static int search(int[] arr, int item) {
        return search(arr, item, 0, arr.length - 1);
    }
}
