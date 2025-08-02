package Arrays;

import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> totalCounts = new HashMap<>();

        // Count all fruits in both baskets
        for (int fruit : basket1)
            totalCounts.put(fruit, totalCounts.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2)
            totalCounts.put(fruit, totalCounts.getOrDefault(fruit, 0) + 1);

        // Check for odd counts and find the minimum value fruit
        long minVal = Long.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : totalCounts.entrySet()) {
            if (entry.getValue() % 2 != 0)
                return -1; // impossible
            minVal = Math.min(minVal, entry.getKey());
        }

        // Determine how many fruits need to be swapped
        List<Long> fruitsToSwap = new ArrayList<>();
        Map<Integer, Integer> count1 = new HashMap<>();
        for (int fruit : basket1)
            count1.put(fruit, count1.getOrDefault(fruit, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : totalCounts.entrySet()) {
            int fruit = entry.getKey();
            int diff = count1.getOrDefault(fruit, 0) - (entry.getValue() / 2);
            for (int i = 0; i < Math.abs(diff); i++) {
                fruitsToSwap.add((long) fruit);
            }
        }

        // Sort fruits to optimize swapping cost
        Collections.sort(fruitsToSwap);

        // Greedy approach: pick smallest costs or double minVal for reverse swap
        long totalCost = 0;
        int swapsToMake = fruitsToSwap.size() / 2;
        for (int i = 0; i < swapsToMake; i++) {
            totalCost += Math.min(fruitsToSwap.get(i), 2 * minVal);
        }

        return totalCost;
    }

    // Testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Equal baskets
        int[] b1 = { 1, 2, 3 };
        int[] b2 = { 2, 3, 1 };
        System.out.println("Test 1: " + sol.minCost(b1, b2)); // Output: 0

        // Test 2: Needs swaps
        int[] b3 = { 1, 1, 2 };
        int[] b4 = { 2, 3, 3 };
        System.out.println("Test 2: " + sol.minCost(b3, b4)); // Output: 2

        // Test 3: Impossible case
        int[] b5 = { 1, 2, 2 };
        int[] b6 = { 1, 1, 2 };
        System.out.println("Test 3: " + sol.minCost(b5, b6)); // Output: -1
    }
}
