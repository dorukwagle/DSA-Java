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
        System.out.println(tree.find(17));
//        tree.traversePreOrder();
//        tree.traverseInOrder();
        tree.traverseInOrderReverse();
//        tree.traversePostOrder();
    }
}
