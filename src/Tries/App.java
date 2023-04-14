package Tries;

public class App {
    public static void main(String[] args) {
        TrieHash trie = new TrieHash();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("cannot");
        trie.insert("catro");
//        System.out.println(trie.contains(null));
//        trie.traversePostOrder();
        trie.remove(null);
        System.out.println(trie.contains("cannot"));
        System.out.println(trie.contains("can"));
        System.out.println("done");
    }

}

