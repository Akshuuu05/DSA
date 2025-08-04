package Arrays;

import java.util.*;

class Solution {

    public int totalFruit(int[] fruits) {
        int start = 0, end = 0;
        int n = fruits.length, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (end < n) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.size() >= 3) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0)
                    map.remove(fruits[start]);
                start++;
            }

            int currLen = end - start + 1;
            maxLen = Math.max(maxLen, currLen);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] fruits1 = { 1, 2, 1 };
        int[] fruits2 = { 0, 1, 2, 2 };
        int[] fruits3 = { 1, 2, 3, 2, 2 };
        int[] fruits4 = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };

        System.out.println("Output 1: " + sol.totalFruit(fruits1)); // 3
        System.out.println("Output 2: " + sol.totalFruit(fruits2)); // 3
        System.out.println("Output 3: " + sol.totalFruit(fruits3)); // 4
        System.out.println("Output 4: " + sol.totalFruit(fruits4)); // 5
    }
}
