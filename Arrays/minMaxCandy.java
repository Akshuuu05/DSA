package Arrays;

import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int min = 0, max = 0, n = prices.length;
        Arrays.sort(prices);

        // Minimum cost
        int r = n - 1, l = 0;
        while (l <= r) {
            min += prices[l++];
            r -= k;
        }

        // Maximum cost
        r = n - 1;
        l = 0;
        while (l <= r) {
            max += prices[r--];
            l += k;
        }

        return new ArrayList<>(Arrays.asList(Integer.valueOf(min), Integer.valueOf(max)));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = { 3, 2, 1, 4 };
        int k = 2;
        System.out.println(sol.minMaxCandy(prices, k)); // Example output: [3, 7]
    }
}
