package Arrays;

class Solution {
    public int countSquares(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && i > 0 && j > 0) {
                    A[i][j] = 1 + Math.min(
                            A[i - 1][j],
                            Math.min(A[i][j - 1], A[i - 1][j - 1]));
                }
                res += A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat1 = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        int[][] mat2 = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        int[][] mat3 = {
                { 1, 1 },
                { 1, 1 }
        };

        System.out.println(sol.countSquares(mat1)); // 15
        System.out.println(sol.countSquares(mat2)); // 7
        System.out.println(sol.countSquares(mat3)); // 5
    }
}
