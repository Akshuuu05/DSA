package Strings;

class Solution {
    int getLPSLength(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // try smaller prefix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n - 1]; // last value gives LPS length
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getLPSLength("abcab"));    // 2  ("ab")
        System.out.println(sol.getLPSLength("aaaa"));     // 3  ("aaa")
        System.out.println(sol.getLPSLength("abcd"));     // 0  (no prefix=suffix)
        System.out.println(sol.getLPSLength("ababab"));   // 4  ("abab")
    }
}

