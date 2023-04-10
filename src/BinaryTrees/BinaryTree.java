package BinaryTrees;

import com.sun.jdi.InvalidStackFrameException;

import java.util.ArrayList;
import java.util.List;

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

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int countLeaves(Node node){
        if(node == null)
            return 0;
        if(node.leftChild == null && node.rightChild == null)
            return 1;
        return countLeaves(node.leftChild) + countLeaves(node.rightChild);
    }

    public int countLeaves(){
        if(firstNode == null)
            return 0;
        return countLeaves(firstNode);
    }

    public int height(){
        return height(firstNode);
    }

    public int min(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (isLeaf(root))
            return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(root.getValue(), Math.min(left, right));
    }

    public int min(){
        if(firstNode == null)
            throw new IllegalStateException();
        return min(firstNode);
    }

    public int binarySearchMin(){
        if(firstNode == null)
            throw new IllegalStateException();
        var cur = firstNode;
        var last = cur;
        while (cur != null){
            last = cur;
            cur = cur.leftChild;
        }
        return last.value;
    }



    private boolean equals(Node n1, Node n2){
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;

        var left = equals(n1.leftChild, n2.leftChild);
        var right = equals(n1.rightChild, n2.rightChild);
        return left && right && n1.value == n2.value;
    }

    public boolean equals(BinaryTree tree){
        if(tree == null)
            return false;
        return equals(firstNode, tree.firstNode);
    }

    private boolean isBinarySearchTree(Node node, int min, int max){
        if (node == null)
            return true;

        if(node.value < min || node.value > max)
            return false;

        return isBinarySearchTree(node.leftChild, min, node.value - 1) &&
                isBinarySearchTree(node.rightChild, node.value + 1, max);
    }

    private void nodeAtKDistance(Node node, int distance){
        if(node == null)
            return;
        if(distance == 0) {
            System.out.println(node.value);
            return;
        }
        nodeAtKDistance(node.leftChild, distance - 1);
        nodeAtKDistance(node.rightChild, distance - 1);
    }

    public void levelOrderTraverse(){
        if(firstNode == null)
            return;
        for (int i = 0; i <= height(firstNode); ++i)
            nodeAtKDistance(i);
    }

    public void nodeAtKDistance(int distance){
        if(firstNode == null)
            throw new InvalidStackFrameException();
        nodeAtKDistance(firstNode, distance);
    }

    private boolean getAncestors(Node parent, int value, List<Integer> list){
        if(parent == null)
            return false;

        if(parent.value == value)
            return true;

        if(getAncestors(parent.leftChild, value, list) || getAncestors(parent.rightChild, value, list)) {
            list.add(parent.value);
            return true;
        }
        return false;
    }

    public void listAncestors(int value){
        List<Integer> lst = new ArrayList<>();
        var found = getAncestors(firstNode, value, lst);
        System.out.println(lst);
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(firstNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
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


