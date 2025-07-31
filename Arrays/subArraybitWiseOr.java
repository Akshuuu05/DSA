package Arrays;

import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> resultOrs = new HashSet<>();
        Set<Integer> currentOrs = new HashSet<>();

        for (int x : arr) {
            Set<Integer> nextOrs = new HashSet<>();

            nextOrs.add(x); // new subarray starts with x

            for (int y : currentOrs) {
                nextOrs.add(x | y); // extend previous subarrays with x
            }

            resultOrs.addAll(nextOrs);
            currentOrs = nextOrs; // update current ORs
        }

        return resultOrs.size();
    }

    public static void runTests() {
        Solution sol = new Solution();

        int[][] testArrays = {
                { 0 },
                { 1, 1, 2 },
                { 1, 2, 4 },
                { 3, 5, 1 },
                { 7, 7, 7 },
                { 1, 2, 3, 4, 5 },
                { 0, 1, 2, 3 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input: " + Arrays.toString(testArrays[i]));
            int res = sol.subarrayBitwiseORs(testArrays[i]);
            System.out.println("Distinct ORs of subarrays: " + res);
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
