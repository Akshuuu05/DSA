package Arrays;

class Solution {
    public int median(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][n - 1]);
        }

        int desired = (m * n + 1) / 2; // position of median

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int i = 0; i < m; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count < desired)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    // Find index of first element > target (upper bound)
    private int upperBound(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // ---------------------
    // Main for testing
    // ---------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat1 = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };
        System.out.println(sol.median(mat1)); // 5

        int[][] mat2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(sol.median(mat2)); // 5

        int[][] mat3 = {
                { 1, 10, 20 },
                { 2, 15, 30 },
                { 5, 18, 35 }
        };
        System.out.println(sol.median(mat3)); // 15
    }
}
