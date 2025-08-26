package Strings;

class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int a = 0, j = 0;

        while (a < s1.length() && j < s2.length()) {
            if (s1.charAt(a) == s2.charAt(j)) {
                a++;
            }
            j++;
        }

        return a == s1.length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isSubSeq("abc", "ahbgdc")); // true
        System.out.println(sol.isSubSeq("axc", "ahbgdc")); // false
        System.out.println(sol.isSubSeq("", "anything")); // true (empty string is subsequence)
        System.out.println(sol.isSubSeq("a", "")); // false
    }
}
