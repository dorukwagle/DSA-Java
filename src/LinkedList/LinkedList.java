package LinkedList;

import javax.xml.stream.FactoryConfigurationError;
import java.util.NoSuchElementException;
import java.util.concurrent.TransferQueue;

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

        if(first == last){
            first = last = null;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
        listSize--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }

        var current = getPrevious(last);
        last = current;
        last.next = null;
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
