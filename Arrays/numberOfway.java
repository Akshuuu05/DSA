package Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1;; i++) {
            int power = (int) Math.pow(i, x);
            if (power > n)
                break;

            for (int sum = n; sum >= power; sum--) {
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10, x = 2;
        System.out.println(sol.numberOfWays(n, x)); // Example: 1^2 + 3^2 = 10 → Output: 1
    }
}
