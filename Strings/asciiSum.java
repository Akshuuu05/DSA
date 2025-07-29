package Strings;

import java.util.*;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        Map<Character, int[]> map = new HashMap<>();

        // First pass: record first and last index of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[] { i, i }); // [start, end]
            } else {
                map.get(ch)[1] = i; // update end
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Second pass: calculate ASCII sum between first and last occurrences
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int start = entry.getValue()[0];
            int end = entry.getValue()[1];

            if (end - start <= 1)
                continue; // nothing strictly between

            int sum = 0;
            for (int i = start + 1; i < end; i++) {
                sum += s.charAt(i);
            }

            if (sum > 0)
                result.add(sum);
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testCases = {
                "abcdbca", // b and c repeat
                "aaaa", // a repeats
                "abcd", // no repeats
                "aabccba", // a, b, and c repeat
                "xyxyxy", // x and y repeat
                ""
        };

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            System.out.println("Test Case #" + (i + 1) + ": \"" + input + "\"");
            ArrayList<Integer> result = sol.asciirange(input);
            System.out.println("Result: " + result);
            System.out.println("---------------------------------");
        }
    }
}
