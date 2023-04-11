package Heaps;

public class Heapify {
    private static int[] array;

    public static void heap(int[] array) {
        Heapify.array = array;
        int len = array.length;
        for (int i = 0; i < len; ++i)
            heapify(i);
    }

    private static void heapify(int index) {
        int largeIndex = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex < array.length && array[leftIndex] > array[largeIndex])
            largeIndex = leftIndex;

        if (rightIndex < array.length && array[rightIndex] > array[largeIndex])
            largeIndex = rightIndex;

        if (index == largeIndex)
            return;

        swap(index, largeIndex);

        heapify(largeIndex);
    }

    private static void swap(int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
