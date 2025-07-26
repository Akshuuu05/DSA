package Arrays;

import java.util.*;

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        Integer candidate1 = null, candidate2 = null;

        // Step 1: Find potential candidates using Boyer-Moore
        for (int num : arr) {
            if (candidate1 != null && candidate1 == num) {
                i++;
            } else if (candidate2 != null && candidate2 == num) {
                j++;
            } else if (i == 0) {
                candidate1 = num;
                i = 1;
            } else if (j == 0) {
                candidate2 = num;
                j = 1;
            } else {
                i--;
                j--;
            }
        }

        // Step 2: Verify actual frequencies
        i = 0;
        j = 0;
        for (int num : arr) {
            if (candidate1 != null && num == candidate1)
                i++;
            else if (candidate2 != null && num == candidate2)
                j++;
        }

        // Step 3: Collect results
        ArrayList<Integer> result = new ArrayList<>();
        if (i > n / 3)
            result.add(candidate1);
        if (j > n / 3)
            result.add(candidate2);

        Collections.sort(result);
        return result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                { 3, 2, 3 }, // Output: [3]
                { 1, 2 }, // Output: [1, 2]
                { 1, 1, 1, 3, 3, 2, 2, 2 }, // Output: [1, 2]
                { 2, 2, 9, 3, 9, 3, 9, 3, 9 }, // Output: [3, 9]
                { 1, 1, 1, 1 }, // Output: [1]
                { 1, 2, 3, 4, 5, 6, 7 }, // Output: []
                { 5, 5, 5, 6, 6, 6, 6 }, // Output: [6]
                { 2, 2 }, // Output: [2]
                {}, // Output: []
                { 0, 0, 0 } // Output: [0]
        };

        int testCaseNumber = 1;
        for (int[] testCase : testCases) {
            ArrayList<Integer> result = sol.findMajority(testCase);
            System.out.println("Test Case " + (testCaseNumber++) + ": " + Arrays.toString(testCase));
            System.out.println("Output: " + result);
            System.out.println("--------------------------------------------------");
        }
    }
}
