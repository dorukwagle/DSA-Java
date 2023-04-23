package algorithms.searchings;

public class LinearSearch {
    public static int search(int[] arr, int item) {
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] == item)
                return i;
        return -1;
    }
}
