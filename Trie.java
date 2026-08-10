import java.util.ArrayList;
import java.util.List;

public class Trie {
    // TRIE NODE
    static class TrieNode {
        // Array is used as the data structure , to store 26 English alphabets
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        TrieNode() {
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    // CONSTRUCTOR
    public Trie() {
        root = new TrieNode();
    }
    // INSERT WORD
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }    // SEARCH WORD
       public boolean search(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            }
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    // GET PREFIX NODE
        private TrieNode getNode(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return null;
            }
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
    // AUTO COMPLETE
    public List<String> autoComplete(String prefix) {
        List<String> result = new ArrayList<>();
        prefix = prefix.toLowerCase();
        TrieNode node = getNode(prefix);
        if (node == null) {
            return result;
        }
        collectWords(node, prefix, result);
        return result;
    }
    // DFS FOR AUTO COMPLETE
    private void collectWords(
            TrieNode node,
            String word,
            List<String> result) {

        if (node.isEndOfWord) {
            result.add(word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) ('a' + i);
                collectWords(
                        node.children[i],
                        word + ch,
                        result
                );
            }
        }
    }
    // DELETE WORD
    public boolean delete(String word) {
        if (!search(word)) {
            return false;
        }
        deleteWord(root, word.toLowerCase(), 0);
        return true;
    }
    private boolean deleteWord(
            TrieNode node,
            String word,
            int depth) {
        if (depth == word.length()) {
            node.isEndOfWord = false;
            return hasNoChildren(node);
        }
        char ch = word.charAt(depth);
        int index = ch - 'a';
        TrieNode child = node.children[index];
        if (child == null) {
            return false;
        }
        boolean shouldDelete =
                deleteWord(
                        child,
                        word,
                        depth + 1
                );

        if (shouldDelete) {
            node.children[index] = null;
        }

        return !node.isEndOfWord &&
                hasNoChildren(node);
    }
    // CHECK CHILDREN
    private boolean hasNoChildren(TrieNode node) {

        for (TrieNode child : node.children) {

            if (child != null) {
                return false;
            }
        }

        return true;
    }
}
