package Arrays;

import java.util.*;

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] last = new int[32]; // last seen index for each bit
        Arrays.fill(last, -1); // initialize to -1
        int[] result = new int[n]; // final result array

        for (int i = n - 1; i >= 0; i--) {
            // Update last seen positions for all bits in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    last[b] = i;
                }
            }

            // Determine the furthest index we need to go to cover all bits
            int farthest = i;
            for (int b = 0; b < 32; b++) {
                if (last[b] != -1) {
                    farthest = Math.max(farthest, last[b]);
                }
            }

            result[i] = farthest - i + 1;
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                { 1, 0, 2, 1, 3 },
                { 1, 2 },
                { 0, 0, 0 },
                { 5, 1, 2 },
                { 7, 7, 7 },
                { 1, 3, 5, 7, 9 }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            int[] res = sol.smallestSubarrays(testCases[i]);
            System.out.println("Result: " + Arrays.toString(res));
            System.out.println("----------------------------------");
        }
    }
}
