package structures.Heaps;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
//        heapTest();
//        heapifyTest();
//        heapSort();
        int[] arr = {3, 5, 8, 9, 23, 44, 21, 15, 88, 34};
        int largest = kthLargestItem(arr, 3);
        System.out.println(largest);
    }

    private static void heapifyTest() {
        Heap heap = new Heap();
        int[] arr = {3, 5, 8, 9, 23, 44, 21, 15, 88, 34};
        int[] ar = {5, 3, 8, 4, 1, 2};
        for (int i : ar)
            heap.insert(i);
        Heapify.heapOptimized(ar);
        System.out.println("done");
    }

    private static void heapTest() {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(4);
        heap.insert(22);
        System.out.println("haha");
        heap.remove();
        System.out.println("done");
    }

    private static void heapSort(){
        Heap heap = new Heap();

        int[] arr = {4, 64, 3, 56, 2, 23, 22, 76};
        for (int i : arr)
            heap.insert(i);
        while(!heap.isEmpty())
            System.out.println(heap.remove());
    }

    private static int kthLargestItem(int[] arr, int k) {
        if (k < 0 || k >= arr.length)
            throw new IllegalArgumentException();

        Heap hp = new Heap();
        Arrays.stream(arr).forEach(hp::insert);
        while(k != 1) {
            hp.remove();
            k--;
        }
        return hp.remove();
    }
}

