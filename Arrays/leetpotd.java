package Arrays;

import java.util.*;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();

        // Extract powers of two from n
        while (n > 0) {
            int lowBit = n & -n; // lowest set bit
            powers.add(lowBit);
            n ^= lowBit; // remove that bit
        }

        int size = powers.size();
        int[][] table = new int[size][size];

        // Precompute products of consecutive powers (mod MOD)
        for (int row = 0; row < size; row++) {
            table[row][row] = powers.get(row);
            for (int col = row + 1; col < size; col++) {
                table[row][col] = (int) ((long) table[row][col - 1] * powers.get(col) % MOD);
            }
        }

        // Answer queries using precomputed table
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int p = queries[i][0];
            int q = queries[i][1];
            result[i] = table[p][q];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 15; // binary: 1111 → powers of two: [1, 2, 4, 8]
        int[][] queries = {
                { 0, 1 }, // 1 * 2 = 2
                { 1, 2 }, // 2 * 4 = 8
                { 0, 3 } // 1 * 2 * 4 * 8 = 64
        };

        int[] ans = sol.productQueries(n, queries);
        System.out.println(Arrays.toString(ans));
    }
}
