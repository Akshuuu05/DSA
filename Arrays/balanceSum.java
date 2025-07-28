package Arrays;

import java.util.*;

class Solution {
    // Main logic to calculate the minimum operations to balance the matrix
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        List<Integer> rowsum = new ArrayList<>();
        List<Integer> colsum = new ArrayList<>();

        int maxSum = Integer.MIN_VALUE;
        int op = 0;

        for (int i = 0; i < n; i++) {
            int rs = 0;
            int cs = 0;
            for (int j = 0; j < m; j++) {
                rs += mat[i][j];
                cs += mat[j][i]; // Assuming square matrix
            }
            rowsum.add(rs);
            colsum.add(cs);
            maxSum = Math.max(maxSum, Math.max(rs, cs));
        }

        for (int i = 0; i < rowsum.size(); i++) {
            op += maxSum - rowsum.get(i);
        }

        return op;
    }

    // Utility function to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Method to test multiple test cases
    public static void runTests() {
        int[][][] testCases = {
                {
                        { 1, 2 },
                        { 3, 4 }
                },
                {
                        { 1, 2, 3 },
                        { 4, 2, 3 },
                        { 3, 2, 1 }
                },
                {
                        { 5, 1 },
                        { 2, 2 }
                },
                {
                        { 1, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 1, 1 }
                },
                {
                        { 1 }
                }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            printMatrix(testCases[i]);
            int result = balanceSums(testCases[i]);
            System.out.println("Minimum operations: " + result);
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
