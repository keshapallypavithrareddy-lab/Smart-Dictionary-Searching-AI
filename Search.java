public class Search {
    // CREATE LPS ARRAY
    private static int[] createLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i)
                    == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    // KMP SEARCH
    public static boolean search(
            String text,
            String pattern) {
        text = text.toLowerCase();
        pattern = pattern.toLowerCase();
        // Empty pattern
        if (pattern.length() == 0) {
            return true;
        }
        int[] lps = createLPS(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (text.charAt(i)
                    == pattern.charAt(j)) {
                i++;
                j++;
                // Pattern found
                if (j == pattern.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
