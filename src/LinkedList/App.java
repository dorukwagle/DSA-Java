package LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.addFirst(23);
        ls.addLast(33);
        ls.addLast(345);

        ls.removeLast();
        System.out.println(ls.contains(345));
    }
}
