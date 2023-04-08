package AVLTrees;

public class AVLTree {
    private class AVLNode {
        private AVLNode leftChild;
        private AVLNode rightChild;
        int value;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    private AVLNode root;

    private void insert(AVLNode node, int value) {
        var valueNode = new AVLNode(value);
        if(node == null)
            return;

        if(node.leftChild == null && value < node.value){
            node.leftChild = valueNode;
            return;
        }

        if(node.rightChild == null && value >= node.value){
            node.rightChild = valueNode;
            return;
        }

        if(value < node.value)
            insert(node.leftChild, value);
        else insert(node.rightChild, value);
    }

    public void insert(int value){
        if(root == null){
            root = new AVLNode(value);
            return;
        }
        insert(root, value);
    }

}
