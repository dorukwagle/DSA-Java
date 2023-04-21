package structures.Stacks;

import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    private int counter;

    public Stack(){
        this.stack = new int[100];
        counter = 0;
    }

    public void push(int item){
        if(counter == stack.length)
            throw new StackOverflowError();
        stack[counter++] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return stack[--counter];
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return stack[counter-1];
    }

    public boolean isEmpty(){
        return counter == 0;
    }

}
