package Heaps;

public class App {
    public static void main(String[] args) {
//        heapTest();
        heapSort();
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
}

