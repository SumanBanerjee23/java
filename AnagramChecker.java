import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {

    public static boolean areAnagrams(String text1, String text2) {
        // Remove spaces and convert to lowercase to make it case-insensitive
        text1 = text1.replaceAll("\\s", "").toLowerCase();
        text2 = text2.replaceAll("\\s", "").toLowerCase();

        // If the lengths are different, they cannot be anagrams
        if (text1.length() != text2.length()) {
            System.out.println("Word1: '" + text1 + "', Word2: '" + text2 + "', Anagram check: false. They are not anagrams.");
            return false;
        }

        // Maintain a character frequency map
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // Increment the frequency for characters in text1
        for (char c : text1.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Decrement the frequency for characters in text2
        for (char c : text2.toCharArray()) {
            int frequency = charFrequencyMap.getOrDefault(c, 0);
            if (frequency == 0) {
                // If the character is not found in text1, it's not an anagram
                System.out.println("Word1: '" + text1 + "', Word2: '" + text2 + "', Anagram check: false. They are not anagrams.");
                return false;
            }
            charFrequencyMap.put(c, frequency - 1);
        }

        // All characters in text2 are accounted for, so they are anagrams
        System.out.println("Word1: '" + text1 + "', Word2: '" + text2 + "', Anagram check: true. They are anagrams.");
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Testing anagram checker:");
        areAnagrams("java", "ajav");
        areAnagrams("Triangle", "square");
        areAnagrams("hello", "world");
        areAnagrams("coding", "dognic");
        areAnagrams("Programming", "Grammar");
        areAnagrams("abbccdd", "dcbbcca");
    }
}
