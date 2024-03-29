package structures.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        public boolean isEmpty() {
            return children.values().toArray(Node[]::new).length == 0;
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public Node[] getChildren() {
            return children.values().toArray(Node[]::new);
        }

        public void removeChild(char c) {
            children.remove(c);
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



    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char c = word.charAt(index);
        Node child = root.getChild(c);

        if (child == null)
            return;

        remove(child, word, index + 1);

        if (child.isEmpty() && !child.isEndOfWord)
            root.removeChild(c);
    }

    private void findWords(Node node, String prefix, List<String> list) {
        if (node == null)
            return;

        if (node.isEndOfWord)
            list.add(prefix);

        for (Node child : node.getChildren())
            findWords(child, prefix + child.value, list);
    }

    private Node findLastNode(String prefix) {
        var current = root;
        for (char c : prefix.toCharArray()) {
            if(!current.hasChild(c))
                return null;
            current = current.getChild(c);
        }
        return current;
    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    public List<String> getWords(String prefix) {
        List<String> list = new ArrayList<>();

        if (prefix == null)
            return list;

        var lastNode = findLastNode(prefix);
        findWords(lastNode, prefix, list);
        return list;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
}
