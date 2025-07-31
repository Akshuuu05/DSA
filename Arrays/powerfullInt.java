package Arrays;

import java.util.*;

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: Mark interval start and end+1
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int count = 0;
        int result = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            count += entry.getValue();

            if (count >= k) {
                result = key; // might be updated again
            }
        }

        return result;
    }

    // Run test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][][] testCases = {
                { { 1, 3 }, { 2, 5 }, { 4, 6 } }, // Overlap at 2–3: count=2, k=2
                { { 1, 2 }, { 2, 3 }, { 3, 4 } }, // No full overlap
                { { 5, 10 }, { 1, 6 }, { 7, 9 } }, // Full overlap at 7-9
                { { 1, 100 }, { 20, 80 }, { 50, 60 } }, // Fully nested intervals
                { { 1, 1 }, { 1, 1 }, { 1, 1 } }, // All single-point intervals
        };

        int[] ks = { 2, 2, 2, 3, 2 };

        for (int i = 0; i < testCases.length; i++) {
            int res = sol.powerfulInteger(testCases[i], ks[i]);
            System.out.println("Test Case #" + (i + 1) + ": Result = " + res);
        }
    }
}
