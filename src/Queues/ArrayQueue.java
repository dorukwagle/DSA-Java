package Queues;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue(int capacity){
        array = new int[capacity];
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return array[front];
    }

    public void enqueue(int item){
        if(isFull())
            throw new StackOverflowError();

        array[rear] = item;
        rear = (rear + 1) % array.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        int item = array[front];
        array[front] = 0;
        count--;
        front = (front + 1) % array.length;
        return item;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    @Override
    public String toString() {
//        int[] arr = Arrays.copyOf(array, rear);
        return "ArrayQueue(" +
                Arrays.toString(array) +
                ")";
    }
}
