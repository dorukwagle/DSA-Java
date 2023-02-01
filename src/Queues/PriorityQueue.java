package Queues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int count = 0;
    private int rear = 0;

    public PriorityQueue(int capacity){
        array = new int[capacity];
    }

    public void add(int item) {
        if(isFull())
            throw new StackOverflowError();
        if(rear == 0)
            array[rear] = item;

        for(int i = rear-1; i >= 0; --i){
            if(item < array[i]){
                array[i + 1] = array[i];
                array[i] = item;
            }
            else if(item > array[i]) {
                array[i + 1] = item;
                break;
            }
        }
        rear = (rear + 1) % array.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        var item = array[rear - 1];
        array[rear - 1] = 0;
        rear = (rear - 1) % array.length;
        count--;
        return item;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return array[rear];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                Arrays.toString(array) +
                '}';
    }
}
