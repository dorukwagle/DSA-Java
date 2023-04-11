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
}
