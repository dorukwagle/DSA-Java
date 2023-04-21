package structures.Heaps;

public class Heap {

    private int[] heap;
    private int counter = 0;

    public Heap(int initialSize) {
        this.heap = new int[initialSize];
    }

    public Heap() {
        this(100);
    }

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException();

        heap[counter++] = value;

        // bubble up
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int root = heap[0];
        heap[0] = heap[--counter];
        bubbleDown();

        return root;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= counter;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= counter;
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (rightChild(index) > leftChild(index)) ?
                rightChildIndex(index) :
                leftChildIndex(index);
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    public boolean isFull() {
        return counter == heap.length;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    private void bubbleUp() {
        int index = counter - 1;
        while (index > 0 && heap[index] > heap[parentIndex(index)]) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= counter && !isValidParent(index)) {
            int largeChildInd = getLargerChildIndex(index);
            swap(largeChildInd, index);
            index = largeChildInd;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        boolean isValid = heap[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= heap[index] >= rightChild(index);

        return isValid;
    }

    private void swap(int ind1, int ind2) {
        int tmp = heap[ind1];
        heap[ind1] = heap[ind2];
        heap[ind2] = tmp;
    }
}
