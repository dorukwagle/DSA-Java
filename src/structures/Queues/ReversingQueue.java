package structures.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversingQueue {
    public static void main(String[] args) {
        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(10);
        qu.add(20);
        qu.add(30);
        qu.add(40);
        System.out.println(qu);
        reverseQueue(qu);
        System.out.println(qu);
    }

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
