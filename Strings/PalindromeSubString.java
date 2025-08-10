package Strings;

class Solution {
    public int countPS(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            // Expand while it's a palindrome
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= 2) { // only count length >= 2
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testStrings = {
                "abba", // abba, bb
                "abc", // no palindrome length >= 2
                "aaa", // aa, aa, aaa
                "racecar" // racecar, aceca, cec
        };

        for (String str : testStrings) {
            System.out.println("String: " + str +
                    " → Palindromic substrings (len ≥ 2): " + sol.countPS(str));
        }
    }
}
