package Strings;

class Solution {
    public static String smallestWindow(String s, String p) {
        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqS = new int[26];
        int start = 0, minLen = Integer.MAX_VALUE, startIndex = -1;
        int count = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqS[c - 'a']++;

            // if this character was needed
            if (freqP[c - 'a'] > 0 && freqS[c - 'a'] <= freqP[c - 'a']) {
                count++;
            }

            // when all characters of p are found
            while (count == p.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }

                // shrink window from left
                char leftChar = s.charAt(start);
                freqS[leftChar - 'a']--;
                if (freqP[leftChar - 'a'] > 0 && freqS[leftChar - 'a'] < freqP[leftChar - 'a']) {
                    count--;
                }
                start++;
            }
        }

        if (startIndex == -1)
            return "-1"; // not found
        return s.substring(startIndex, startIndex + minLen);
    }

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc")); // Expected: "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza")); // Expected: "apzo"
        System.out.println(smallestWindow("abcdef", "xyz")); // Expected: "-1"
    }
}
