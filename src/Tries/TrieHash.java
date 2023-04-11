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

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if(cur.children.get(c) == null)
                cur.children.put(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.isEndOfWord = true;
    }
}
