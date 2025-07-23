package Strings;

//public class sol3 {
class Solution {

    public int maximumGain(String s, int x, int y) {
        int score = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        char ch1 = 'a', ch2 = 'b';
        int cnt1 = 0, cnt2 = 0;

        // Always prioritize the higher scoring pair
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            ch1 = 'b';
            ch2 = 'a';
        }

        for (int i = 0; i < len; i++) {
            if (chars[i] == ch1) {
                cnt1++;
            } else if (chars[i] == ch2) {
                if (cnt1 > 0) {
                    cnt1--;
                    score += x;
                } else {
                    cnt2++;
                }
            } else {
                score += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }

        if (cnt1 != 0 || cnt2 != 0) {
            score += Math.min(cnt1, cnt2) * y;
        }

        return score;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "cdbcbbaaabab";
        int x1 = 4, y1 = 5;
        int result1 = sol.maximumGain(s1, x1, y1);
        System.out.println("Input: s = \"" + s1 + "\", x = " + x1 + ", y = " + y1);
        System.out.println("Output: " + result1); // Expected: 19

        String s2 = "aabbaaxybbaabb";
        int x2 = 5, y2 = 4;
        int result2 = sol.maximumGain(s2, x2, y2);
        System.out.println("\nInput: s = \"" + s2 + "\", x = " + x2 + ", y = " + y2);
        System.out.println("Output: " + result2); // Expected: 20
    }
}
