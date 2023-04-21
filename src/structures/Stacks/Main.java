package structures.Stacks;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(34);
        stack.push(45);
        stack.push(65);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
//        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
