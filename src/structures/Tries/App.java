package structures.Tries;

public class App {
    public static void main(String[] args) {
        TrieHash trie = new TrieHash();
        trie.insert("caat");
        trie.insert("caan");
        trie.insert("caannot");
        trie.insert("caatro");
        trie.insert("canibal");
        trie.insert("patrol");
        trie.insert("patrollium");
        trie.insert("patting");
        trie.insert("patnot");
        trie.insert("patnice");
        trie.insert("patrolling");
//        System.out.println(trie.contains(null));
//        trie.traversePostOrder();
        trie.remove(null);
        System.out.println(trie.getWords(""));
        System.out.println("done");
    }

}

