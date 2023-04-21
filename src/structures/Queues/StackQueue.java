package structures.Queues;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public StackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue() {
        if(stack2.isEmpty())
            manageStack();
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty())
            manageStack();
        return stack2.peek();
    }

    private void manageStack(){
        if(isEmpty())
            throw new IllegalStateException();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
