package Arrays;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDiagonal = Integer.MIN_VALUE;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int a = dimensions[i][0];
            int b = dimensions[i][1];

            int diagonalSq = a * a + b * b; // avoid sqrt
            int area = a * b;

            if (diagonalSq > maxDiagonal) {
                maxDiagonal = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonal && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] dims1 = { { 3, 4 }, { 6, 8 }, { 5, 12 }, { 9, 12 } };
        System.out.println(sol.areaOfMaxDiagonal(dims1)); // Expected 108

        int[][] dims2 = { { 2, 3 }, { 4, 4 }, { 3, 5 } };
        System.out.println(sol.areaOfMaxDiagonal(dims2)); // Expected 16

        int[][] dims3 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println(sol.areaOfMaxDiagonal(dims3)); // Expected 18
    }
}
