package AVLTrees;

public class AVLTree {
    private class AVLNode {
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int value;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    private AVLNode root;

    private AVLNode insert(AVLNode node, int value) {
        if(node == null)
            return new AVLNode(value);

        if(value < node.value)
            node.leftChild = insert(node.leftChild, value);
        else
            node.rightChild = insert(node.rightChild, value);

       return node;
    }

    public void insert(int value){
        root = insert(root, value);
    }

}
