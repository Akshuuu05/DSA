package Arrays;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        if (n == 0) {
            return 0;
        }

        int[] positions = new int[n];
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            positions[i] = fruits[i][0];
            prefixSum[i + 1] = prefixSum[i] + fruits[i][1];
        }

        long maxFruits = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            long posL = positions[left];
            long posR = positions[right];

            // Calculate the minimum steps to cover the current window [posL, posR]
            long cost = (posR - posL) + Math.min(Math.abs(startPos - posL), Math.abs(startPos - posR));

            // If the cost is too high, shrink the window from the left
            while (left <= right && cost > k) {
                left++;
                if (left > right)
                    break;
                posL = positions[left];
                cost = (posR - posL) + Math.min(Math.abs(startPos - posL), Math.abs(startPos - posR));
            }

            // If the window is valid, calculate fruits and update max
            if (left <= right) {
                long currentFruits = prefixSum[right + 1] - prefixSum[left];
                maxFruits = Math.max(maxFruits, currentFruits);
            }
        }

        return (int) maxFruits;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] fruits1 = { { 2, 4 }, { 4, 3 }, { 6, 1 }, { 8, 5 } };
        int startPos1 = 5;
        int k1 = 4;
        System.out.println("Test 1: " + sol.maxTotalFruits(fruits1, startPos1, k1)); // Expected: 7

        int[][] fruits2 = { { 1, 2 }, { 3, 3 }, { 6, 5 } };
        int startPos2 = 3;
        int k2 = 2;
        System.out.println("Test 2: " + sol.maxTotalFruits(fruits2, startPos2, k2)); // Expected: 5

        int[][] fruits3 = { { 0, 5 }, { 3, 2 }, { 9, 4 } };
        int startPos3 = 4;
        int k3 = 10;
        System.out.println("Test 3: " + sol.maxTotalFruits(fruits3, startPos3, k3)); // Expected: 11
    }
}
