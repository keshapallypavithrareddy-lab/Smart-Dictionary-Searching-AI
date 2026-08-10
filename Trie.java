import java.util.ArrayList;
import java.util.List;

public class Trie {

    // Trie Node
      // Insert word
    // Search exact word
    // Auto-complete
    // Get node for prefix
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }
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
    }
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

    // DFS to collect words
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

    // Delete word
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
                deleteWord(child, word, depth + 1);

        if (shouldDelete) {
            node.children[index] = null;
        }

        return !node.isEndOfWord &&
                hasNoChildren(node);
    }

    private boolean hasNoChildren(TrieNode node) {

        for (TrieNode child : node.children) {

            if (child != null) {
                return false;
            }
        }

        return true;
    }
}
