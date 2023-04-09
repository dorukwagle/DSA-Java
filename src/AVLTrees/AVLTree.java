package AVLTrees;

public class AVLTree {
    private class AVLNode {
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int value;
        private int height = 0;

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

        // calculate the node height
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));

        // check for balance factor
        balance(node);
       return node;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1: node.height;
    }

    private void balance(AVLNode node) {
        if(isLeftHeavy(node)) {
            // node is left heavy, right rotation required
            if(balanceFactor(node.leftChild) < 0)
                System.out.println(node.value + " requires left right");
            else System.out.println(node.value + " requires right rotation");
        }
        if(isRightHeavy(node)){
            if(balanceFactor(node.rightChild) > 0)
                System.out.println(node.value + " requires right left rotation");
                // node is right heavy, left rotation required
            else System.out.println(node.value + " requires left rotation");
        }
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
            return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public int height(){
        return height(root);
    }
}
