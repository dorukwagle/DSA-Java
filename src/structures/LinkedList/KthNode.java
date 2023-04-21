/**
 * Find the Kth node from the end
 * of a linked list in one pass.
 *
 * [20, 30, 40, 50, 60, 70]
 * k = 1 => 70
 * k = 2 => 60
 * k = 3 => 50
 */

package structures.LinkedList;

public class KthNode {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(23);
        list.addLast(34);
        list.addLast(55);
        list.addLast(54);
        list.addLast(77);
        list.addLast(75);
        list.addLast(98);

        System.out.println(list.getKthNodeFromTheEnd(4));

    }
}
