package Arrays;

import java.util.*;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int count = 0;
        int prefixSum = 0;
        prefixSumMap.put(0, 1); // base case: subarray starting from index 0

        for (int num : arr) {
            prefixSum += num;

            // Check if there is a prefix sum that leads to sum = k
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            // Update map with current prefixSum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void runTests() {
        Solution sol = new Solution();

        int[][] testArrays = {
                { 1, 1, 1 }, // sum=2 appears twice
                { 1, 2, 3 }, // sum=3 appears twice: [3], [1,2]
                { 0, 0, 0, 0 }, // sum=0 appears in 10 subarrays (triangular number)
                { -1, -1, 1 }, // sum=0 appears once
                { 1, -1, 0 }, // sum=0 appears 3 times
                { 3, 4, 7, 2, -3, 1, 4, 2 } // sum=7 appears 4 times
        };

        int[] ks = { 2, 3, 0, 0, 0, 7 };

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input Array: " + Arrays.toString(testArrays[i]));
            System.out.println("k = " + ks[i]);
            int res = sol.cntSubarrays(testArrays[i], ks[i]);
            System.out.println("Subarrays with sum " + ks[i] + ": " + res);
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
