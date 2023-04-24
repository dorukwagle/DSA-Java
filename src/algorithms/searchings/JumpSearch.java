package algorithms.searchings;

import java.util.Map;

public class JumpSearch {
    public static int search(int[] arr, int item) {
        int partitionSize = (int) Math.sqrt(arr.length);
        int start = 0;
        int next = partitionSize;

        while (start < arr.length && arr[next - 1] < item) {
            start = next;
            next = Math.min(next + partitionSize, arr.length);
        }

        for (int i = start; i < next; ++i)
            if (arr[i] == item)
                return i;

        return -1;
    }
}
