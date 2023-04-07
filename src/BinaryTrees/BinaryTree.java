package BinaryTrees;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    private Node firstNode;

    public void insert(int value){
        Node node = new Node(value);
        if(firstNode == null) {
            firstNode = new Node(value);
            return;
        }
        var cur = firstNode;
        while(true){
            var left = cur.leftChild;
            var right = cur.rightChild;
            if(cur.getValue() < value){
                if(right == null) {
                    cur.rightChild = node;
                    break;
                }
                else cur = right;
            }
            else {
                if(left == null) {
                    cur.leftChild = node;
                    break;
                }
                else cur = left;
            }
        }
    }

    public boolean find(int value){
        Node cur = firstNode;

        while (cur != null){
            if(cur.getValue() == value)
                return true;
            if(cur.rightChild != null && cur.rightChild.getValue() <= value)
                cur = cur.rightChild;
            else cur = cur.leftChild;
        }
        return false;
    }

    private void traversePreOrder(Node root){
        if (root == null)
            return;
        // root, left, right
        System.out.println(root.getValue());
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if (root == null)
            return;
        // left, root, right
        traverseInOrder(root.leftChild);
        System.out.println(root.getValue());
        traverseInOrder(root.rightChild);
    }

    private void traverseInOrderReverse(Node root){
        if (root == null)
            return;
        // right, root, left
        traverseInOrder(root.rightChild);
        System.out.println(root.getValue());
        traverseInOrder(root.leftChild);
    }

    private void traversePostOrder(Node root){
        if (root == null)
            return;
        // left, right, root
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.getValue());
    }

    private int height(Node root){
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int height(){
        return height(firstNode);
    }

    public void traversePreOrder(){
        traversePreOrder(firstNode);
    }

    public void traverseInOrder(){
        traverseInOrder(firstNode);
    }

    public void traverseInOrderReverse(){
        traverseInOrderReverse(firstNode);
    }

    public void traversePostOrder(){
        traversePostOrder(firstNode);
    }

}


