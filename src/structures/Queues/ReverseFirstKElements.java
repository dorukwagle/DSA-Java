/**
 * Program to reverse the first K number of elements from a queue
 * e.g.  [1, 2, 3, 4, 5, 6, 7] . if K = 3; then queue becomes [3, 2, 1, 4, 5, 6, 7]
 */


package structures.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
    public static void reverseKElements(Queue<Integer> queue, int K){
        Queue<Integer> temp = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= K; i++){
            stack.push(queue.remove());
        }
        while (!queue.isEmpty())
            temp.add(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        while (!temp.isEmpty())
            queue.add(temp.remove());
    }

//    a more efficient iteration of the above method

    public static void reverseQueue(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();

        if (k > queue.size() || k < 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < k; ++i)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < queue.size() - k; ++i)
            queue.add(queue.remove());
    }

    public static void main(String[] args) {
        Queue<Integer> test = new ArrayDeque<>();
        test.add(23);
        test.add(32);
        test.add(43);
        test.add(56);
        test.add(78);
        test.add(88);
        test.add(98);
        test.add(99);

        reverseQueue(test, 5);
        test.forEach(System.out::println);
    }
}
