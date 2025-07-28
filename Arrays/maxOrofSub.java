package Arrays;

import java.util.*;

public class Solution {

    // Recursive helper method to count subsets whose OR == maxOr
    private int solve(int nums[], int maxOr, int currOr, int idx) {
        if (idx >= nums.length) {
            return currOr == maxOr ? 1 : 0;
        }

        // Include current element
        int take = solve(nums, maxOr, currOr | nums[idx], idx + 1);
        // Exclude current element
        int skip = solve(nums, maxOr, currOr, idx + 1);

        return take + skip;
    }

    // Main method to be called
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        return solve(nums, maxOr, 0, 0);
    }

    // Utility method to run multiple test cases
    public static void runTests() {
        Solution sol = new Solution();

        int[][] testCases = {
                { 3, 1 }, // maxOr = 3
                { 2, 2, 2 }, // all ORs = 2
                { 1, 2, 3 }, // maxOr = 3
                { 1 }, // maxOr = 1
                { 0, 0, 0 }, // maxOr = 0
                { 5, 1, 2, 3 }, // maxOr = 7
                { 1, 1, 1, 1 } // maxOr = 1
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            int result = sol.countMaxOrSubsets(testCases[i]);
            System.out.println("Count of max OR subsets: " + result);
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
