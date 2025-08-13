package Arrays;

import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2;

        int luckyCount = 0;
        List<Integer> costs = new ArrayList<>();

        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                luckyCount++;
            } else {
                costs.add((k - soldiers % k) % k);
            }
        }

        if (luckyCount >= required) {
            return 0;
        }

        Collections.sort(costs);
        int totalCost = 0;
        int needed = required - luckyCount;
        for (int i = 0; i < needed; i++) {
            totalCost += costs.get(i);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 5, 10, 7, 14, 3 };
        int k1 = 5;
        System.out.println("Minimum cost: " + sol.minSoldiers(arr1, k1)); // Expected: 5

        int[] arr2 = { 4, 8, 12 };
        int k2 = 4;
        System.out.println("Minimum cost: " + sol.minSoldiers(arr2, k2)); // Expected: 0

        int[] arr3 = { 1, 2, 3, 4, 5 };
        int k3 = 3;
        System.out.println("Minimum cost: " + sol.minSoldiers(arr3, k3)); // Expected: depends on calculation
    }
}
