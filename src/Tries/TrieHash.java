package Tries;

import java.util.HashMap;

public class TrieHash {
    private class Node {
        private char value;

        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord = false;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char c) {
            return children.containsKey(c);
        }

        public void addChild(char c) {
            children.put(c, new Node(c));
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public Node[] getChildren() {
            return children.values().toArray(Node[]::new);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if(!cur.hasChild(c))
                cur.addChild(c);
            cur = cur.getChild(c);
        }
        cur.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.hasChild(c))
                return false;
            cur = cur.getChild(c);
        }
        return cur.isEndOfWord;
    }

    private void traversePreOrder(Node root) {
        System.out.println(root.value);
        for (var child : root.getChildren())
            traversePreOrder(child);
    }

    private void traversePostOrder(Node root) {
        for (var child : root.getChildren())
            traversePostOrder(child);
        System.out.println(root.value);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
}
