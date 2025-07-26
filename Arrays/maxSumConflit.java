package Arrays;

import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // Ensure pairs are in ascending order
        for (int[] pair : conflictingPairs) {
            if (pair[1] < pair[0]) {
                int temp = pair[0];
                pair[0] = pair[1];
                pair[1] = temp;
            }
        }

        // Sort pairs by the second value
        Arrays.sort(conflictingPairs, Comparator.comparingInt(a -> a[1]));

        int m = conflictingPairs.length;
        int max1 = 0;
        int max2 = 0;
        long gain = 0;
        long maxGain = 0;
        long totalOccupied = 0;

        for (int i = 0; i < m; i++) {
            int start = conflictingPairs[i][0];
            int base = n + 1 - conflictingPairs[i][1];
            if (i < m - 1) {
                base = conflictingPairs[i + 1][1] - conflictingPairs[i][1];
            }

            if (start > max1) {
                max2 = max1;
                max1 = start;
                gain = 0;
            } else if (start > max2) {
                max2 = start;
            }

            gain += (long) (max1 - max2) * base;
            totalOccupied += (long) max1 * base;

            if (gain > maxGain) {
                maxGain = gain;
            }
        }

        long total = (long) n * (n + 1) / 2;
        return total - totalOccupied + maxGain;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // List of test cases
        int[][][] allPairs = {
                { { 1, 3 }, { 2, 5 }, { 4, 7 }, { 3, 6 }, { 2, 7 } },
                { { 1, 2 }, { 2, 3 }, { 3, 5 }, { 5, 7 }, { 7, 9 }, { 9, 10 }, { 4, 6 }, { 6, 8 }, { 8, 10 },
                        { 1, 10 } },
                { { 2, 4 }, { 5, 8 }, { 3, 9 }, { 1, 12 }, { 6, 11 }, { 4, 10 } },
                { { 1, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 }, { 9, 15 }, { 10, 14 }, { 11, 13 }, { 5, 12 } },
                { { 1, 20 }, { 2, 19 }, { 3, 18 }, { 4, 17 }, { 5, 16 }, { 6, 15 }, { 7, 14 }, { 8, 13 }, { 9, 12 },
                        { 10, 11 }, { 2, 10 } },
                { { 1, 13 }, { 2, 14 }, { 3, 15 }, { 4, 16 }, { 5, 17 }, { 6, 18 }, { 7, 19 }, { 8, 20 } },
                { { 1, 30 }, { 2, 29 }, { 3, 28 }, { 4, 27 }, { 5, 26 }, { 6, 25 }, { 7, 24 }, { 8, 23 }, { 9, 22 },
                        { 10, 21 }, { 11, 20 }, { 12, 19 } },
                { { 1, 50 }, { 2, 49 }, { 3, 48 }, { 4, 47 }, { 5, 46 }, { 6, 45 }, { 7, 44 }, { 8, 43 }, { 9, 42 },
                        { 10, 41 }, { 11, 40 }, { 12, 39 }, { 13, 38 }, { 14, 37 }, { 15, 36 } }
        };

        int[] ns = { 7, 10, 12, 15, 20, 25, 30, 50 };

        for (int i = 0; i < ns.length; i++) {
            long result = sol.maxSubarrays(ns[i], allPairs[i]);
            System.out.println("Test Case " + (i + 1) + ": n = " + ns[i]);
            System.out.println("Conflicting Pairs: " + Arrays.deepToString(allPairs[i]));
            System.out.println("Max Non-conflicting Subarrays: " + result);
            System.out.println("---------------------------------------------------");
        }
    }
}
