package Arrays;

class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int m = fruits[0].length;

        int[][][] dp = new int[n][m][m];

        // Initialize DP with -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < m; k++)
                    dp[i][j][k] = -1;

        // Start from row 0, person1 at col 0, person2 at col m-1
        dp[0][0][m - 1] = fruits[0][0] + (0 == m - 1 ? 0 : fruits[0][m - 1]);

        for (int i = 1; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int pj1 = j1 - d1;
                            int pj2 = j2 - d2;

                            if (pj1 >= 0 && pj1 < m && pj2 >= 0 && pj2 < m && dp[i - 1][pj1][pj2] != -1) {
                                int val = dp[i - 1][pj1][pj2];
                                val += fruits[i][j1];
                                if (j1 != j2)
                                    val += fruits[i][j2];

                                dp[i][j1][j2] = Math.max(dp[i][j1][j2], val);
                            }
                        }
                    }
                }
            }
        }

        int maxFruits = 0;
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                maxFruits = Math.max(maxFruits, dp[n - 1][j1][j2]);
            }
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] fruits = {
                { 1, 2, 3 },
                { 0, 1, 4 },
                { 2, 0, 1 }
        };

        System.out.println("Max Fruits Collected: " + sol.maxCollectedFruits(fruits)); // Output should be 10
    }
}
