package BinaryTrees;

public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(6);
        tree.insert(1);
        tree.insert(8);
        tree.insert(12);
        tree.insert(18);
        tree.insert(17);

        BinaryTree tree2 = new BinaryTree();
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(15);
        tree2.insert(6);
        tree2.insert(1);
        tree2.insert(8);
        tree2.insert(12);
        tree2.insert(18);
        tree2.insert(17);
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traverseInOrderReverse();
//        tree.traversePostOrder();
//        System.out.println(tree.height());
//        System.out.println(tree.binarySearchMin());
        System.out.println(tree.equals(tree2));
    }
}
