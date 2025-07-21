package Strings;

import java.util.*;

public class sol2 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0, maxlen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxlen = Math.max(maxlen, j - i + 1);
        }

        return maxlen;
    }

    // Main method to test the function
    public static void main(String[] args) {
        sol2 sol = new sol2();

        // Test Case 1
        String input1 = "abcabcbb";
        System.out.println("Input: \"abcabcbb\"");
        System.out.println("Output: " + sol.lengthOfLongestSubstring(input1)); // Expected: 3 ("abc")

        // Test Case 2
        String input2 = "bbbbb";
        System.out.println("\nInput: \"bbbbb\"");
        System.out.println("Output: " + sol.lengthOfLongestSubstring(input2)); // Expected: 1 ("b")

        // Test Case 3
        String input3 = "pwwkew";
        System.out.println("\nInput: \"pwwkew\"");
        System.out.println("Output: " + sol.lengthOfLongestSubstring(input3)); // Expected: 3 ("wke")

        // Test Case 4
        String input4 = "";
        System.out.println("\nInput: \"\"");
        System.out.println("Output: " + sol.lengthOfLongestSubstring(input4)); // Expected: 0
    }
}
