package Arrays;

import java.util.*;

class Solution {
    // Method to find longest subarray where all elements are equal to the max value
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int maxLen = 0;
        int currentLen = 0;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest streak of max value
        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }

        return maxLen;
    }

    // Method to run test cases
    public static void runTests() {
        Solution sol = new Solution();

        int[][] testCases = {
                { 1, 3, 3, 2, 3, 3, 3, 1 }, // longest 3s = 3
                { 1, 1, 1, 1 }, // all 1s = 4
                { 1, 2, 3, 4 }, // single 4 = 1
                { 4, 4, 4, 2, 1, 4, 4 }, // longest 4s = 3
                { 5 }, // one element = 1
                { 7, 5, 7, 7, 7, 3, 7, 7 }, // longest 7s = 3
                { 0, 0, 0, 0, 0 } // all 0s = 5
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            int result = sol.longestSubarray(testCases[i]);
            System.out.println("Longest max-value subarray length: " + result);
            System.out.println("-------------------------------------");
        }
    }

    // Main method
    public static void main(String[] args) {
        runTests();
    }
}
