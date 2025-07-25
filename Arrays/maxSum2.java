package Arrays;

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        int ans = 0;
        int maxnum = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            maxnum = Math.max(maxnum, i);
            if (i <= 0)
                continue;

            if (!set.contains(i)) {
                set.add(i);
                ans += i;
            }
        }

        return ans == 0 ? maxnum : ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, // Expected: 45
                { 21, 21, 21, 21, 21, 21, 21, 21 }, // Expected: 21 (unique)
                { -2, -2, -2, -2, -2, -2, -2 }, // Expected: -2
                { -100, -99, -3, -29, 1, -22, -34, -20, -9 }, // Expected: 1
                { -100, -100 }, // Expected: -100
                { 0 }, // Expected: 0
                { -3, -4, -5, -6, -7, -8 }, // Expected: -3
                { 0, 0, 0, 0, 0 } // Expected: 0
        };

        int testCaseNumber = 1;
        for (int[] testCase : testCases) {
            System.out.println("Test Case " + testCaseNumber++ + ": " + Arrays.toString(testCase));
            int result = sol.maxSum(testCase);
            System.out.println("Output: " + result);
            System.out.println("-----------");
        }
    }
}
