package structures.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first = null;
    private Node last = null;

    private int listSize = 0;

    public void addFirst(int first){
        Node temp = new Node(first);

        if(isEmpty())
            this.first = this.last = temp;
        else{
            temp.next = this.first;
            this.first = temp;
        }
        listSize++;
    }

    public void addLast(int last){
        Node temp = new Node(last);

        if(isEmpty())
            this.first = this.last = temp;
        else {
            this.last.next = temp;
            this.last = temp;
        }
        listSize++;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        listSize--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else {
            var current = getPrevious(last);
            last = current;
            last.next = null;
        }
        listSize--;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public int indexOf(int value){
        int index = 0;
        Node current = this.first;
        while(current != null){
            if(current.value == value)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size(){
        return this.listSize;
    }

    public int[] toArray(){
        int[] array = new int[listSize];
        var current = first;
        var index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

//    my implementation
    public void reverse(){
        if(isEmpty())
            return;

        var current = first.next;
        last = first;
        while (current != null){
            var next = current.next;
            current.next = first;
            first = current;
            current = next;
        }
        last.next = null;
    }

//    Mosh's implementation
    public void reversed(){
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

//    My Solution
    public int getKthNodeFromTheEnd(int K){
        if(isEmpty())
            throw new IllegalStateException();
        if(K < 1 || K > listSize)
            throw new IllegalArgumentException();

        int count = 0;
        Node p1, p2;
        p1 = p2 = first;
        // place the last pointer at suitable node
        while ((K-1) != count){
            p2 = p2.next;
            count++;
        }
        // now move both the pointers forward until the p2 reaches last node
        while (p2 != last){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1.value;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPrevious(Node node){
        var previous = first;
        while (previous != null) {
            if(previous.next == node)
                return previous;
            previous = previous.next;
        }
        return null;
    }
}