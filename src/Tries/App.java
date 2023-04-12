package Tries;

public class App {
    public static void main(String[] args) {
        TrieHash trie = new TrieHash();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("catro");
        System.out.println(trie.contains(null));
        System.out.println("done");
    }

}

