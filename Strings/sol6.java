package Strings;

import java.util.*;

class Solution {

    public int romanToDecimal(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int curr = m.get(s.charAt(i));
            int next = (i + 1 < n) ? m.get(s.charAt(i + 1)) : 0;

            if (curr < next) {
                total += (next - curr);
                i++; // skip the next character
            } else {
                total += curr;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Roman to Decimal of MCMIV: " + sol.romanToDecimal("MCMIV")); // 1904
        System.out.println("Roman to Decimal of IX: " + sol.romanToDecimal("IX")); // 9
        System.out.println("Roman to Decimal of XL: " + sol.romanToDecimal("XL")); // 40
        System.out.println("Roman to Decimal of MMXXIV: " + sol.romanToDecimal("MMXXIV"));// 2024
    }
}
