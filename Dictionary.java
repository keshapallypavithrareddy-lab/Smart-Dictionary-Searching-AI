import java.util.HashMap;
import java.util.List;

public class Dictionary {
//addword
//search word
//delete word
//autocomplete word
// pattern search
// display words
    private Trie trie;
    private HashMap<String, String> meanings;

    public Dictionary() {

        trie = new Trie();
        meanings = new HashMap<>();
    }
    public void addWord(
            String word,
            String meaning) {

        word = word.toLowerCase();

        trie.insert(word);

        meanings.put(word, meaning);

        System.out.println(
                "Word added successfully!"
        );
    }

    public void searchWord(String word) {

        word = word.toLowerCase();

        if (trie.search(word)) {

            System.out.println(
                    "\nWord: " + word
            );

            System.out.println(
                    "Meaning: " + meanings.get(word)
            );

        } else {

            System.out.println(
                    "Word not found!"
            );
        }
    }

    public void deleteWord(String word) {

        word = word.toLowerCase();

        if (trie.search(word)) {

            trie.delete(word);

            meanings.remove(word);

            System.out.println(
                    "Word deleted successfully!"
            );

        } else {

            System.out.println(
                    "Word not found!"
            );
        }
    }
    public void autoComplete(String prefix) {

        List<String> words =
                trie.autoComplete(prefix);

        if (words.isEmpty()) {

            System.out.println(
                    "No suggestions found!"
            );

        } else {

            System.out.println(
                    "\nSuggestions:"
            );

            for (String word : words) {

                System.out.println(word);
            }
        }
    }
    public void patternSearch(String pattern) {

        boolean found = false;

        System.out.println(
                "\nWords containing: " + pattern
        );

        for (String word : meanings.keySet()) {

            if (Search.search(word, pattern)) {

                System.out.println(word);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No matching words found!"
            );
        }
    }
    public void displayAllWords() {

        System.out.println(
                "\n===== DICTIONARY ====="
        );

        for (String word : meanings.keySet()) {

            System.out.println(
                    word + " : " + meanings.get(word)
            );
        }
    }
}
