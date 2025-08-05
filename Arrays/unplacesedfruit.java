package Arrays;

import java.util.*;

class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Arrays.sort(fruits); // Sort fruits by size (ascending)
        Arrays.sort(baskets); // Sort baskets by capacity (ascending)

        int i = 0; // fruit pointer
        int j = 0; // basket pointer

        int n = fruits.length;
        int m = baskets.length;

        while (i < n && j < m) {
            if (baskets[j] >= fruits[i]) {
                // Basket can hold the fruit
                i++;
                j++;
            } else {
                // Basket too small, try next larger basket
                j++;
            }
        }

        // Fruits that couldn't be placed
        return n - i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fruits1 = { 2, 3, 1 };
        int[] baskets1 = { 1, 2, 2 };

        int[] fruits2 = { 4, 5, 2 };
        int[] baskets2 = { 1, 1, 1 };

        System.out.println("Unplaced fruits (Test 1): " + sol.numOfUnplacedFruits(fruits1, baskets1)); // Output: 1
        System.out.println("Unplaced fruits (Test 2): " + sol.numOfUnplacedFruits(fruits2, baskets2)); // Output: 3
    }
}
