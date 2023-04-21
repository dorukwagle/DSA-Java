package structures.AVLTrees;

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
        setHeight(node);

        // balance if needed
        return balance(node);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1: node.height;
    }

    private void setHeight(AVLNode node){
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private AVLNode balance(AVLNode node) {
        AVLNode root = node;

        if(isLeftHeavy(root)) {
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        if(isRightHeavy(root)){
            if(balanceFactor(node.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;

        newRoot.leftChild = root.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
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
