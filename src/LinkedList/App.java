package LinkedList;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        System.out.println(ls.size());
        ls.addFirst(23);
        ls.addFirst(34);
        ls.addFirst(44);
        ls.addFirst(47);
        ls.reversed();
        System.out.println(Arrays.toString(ls.toArray()));
        ls.reversed();
        System.out.println(Arrays.toString(ls.toArray()));
    }
}
