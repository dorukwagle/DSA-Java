package structures.Tries;

public class Trie {
    private static final int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
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
            int ind = c - 'a';
            if(cur.children[ind] == null)
                cur.children[ind] = new Node(c);
            cur = cur.children[ind];
        }
        cur.isEndOfWord = true;
    }
}
