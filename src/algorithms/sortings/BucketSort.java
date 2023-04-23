package algorithms.sortings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void sort(int[] arr, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : arr)
            buckets.get(item / numberOfBuckets).add(item);

        int i = 0;
        for (var bucket : buckets) {
            Collections.sort(bucket);
            for (var item : bucket)
                arr[i++] = item;
        }
    }
}
