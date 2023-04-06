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

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
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
            var left = cur.getLeftChild();
            var right = cur.getRightChild();
            if(cur.getValue() < value){
                if(right == null) {
                    cur.setRightChild(node);
                    break;
                }
                else cur = right;
            }
            else {
                if(left == null) {
                    cur.setLeftChild(node);
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
            if(cur.getRightChild() != null && cur.getRightChild().getValue() <= value)
                cur = cur.getRightChild();
            else cur = cur.getLeftChild();
        }
        return false;
    }
}


