package Strings;

class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();

        // Start from largest proper prefix and go down
        for (int len = n - 1; len >= 1; len--) {
            boolean value = true;

            for (int i = len; i < n; i++) {
                if (s.charAt(i) != s.charAt(i % len)) {
                    value = false;
                    break;
                }
            }

            if (value)
                return len;
        }

        return -1; // no such prefix
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testStrings = {
                "ababab", // prefix "ab" length = 2
                "aaaaaa", // prefix "a" length = 1
                "abcabcabc", // prefix "abc" length = 3
                "abcd" // no repeating prefix
        };

        for (String str : testStrings) {
            System.out.println("String: " + str +
                    " → Longest Prefix Length: " + sol.getLongestPrefix(str));
        }
    }
}
