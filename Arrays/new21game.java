package Arrays;

class Solution {
    public double new21Game(int N, int K, int maxPts) {
        // Edge cases:
        // If Alice never draws (K == 0) or if even the max sum is within N, probability
        // = 1
        if (K == 0 || N >= K - 1 + maxPts)
            return 1.0;

        double[] dp = new double[maxPts];
        dp[0] = 1.0;

        double windowSum = 1.0, result = 0.0;

        for (int i = 1; i <= N; i++) {
            double prob = windowSum / maxPts;

            if (i < K) {
                // Still drawing
                windowSum += prob;
            } else {
                // Game ends, add to result
                result += prob;
            }

            // Slide the window
            if (i >= maxPts) {
                windowSum -= dp[i % maxPts];
            }

            dp[i % maxPts] = prob;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.new21Game(10, 1, 10)); // Expected: 1.0
        System.out.println(sol.new21Game(6, 1, 10)); // Expected: 0.6
        System.out.println(sol.new21Game(21, 17, 10)); // Expected around: 0.73278
        System.out.println(sol.new21Game(0, 0, 1)); // Expected: 1.0
    }
}
