package Arrays;

import java.util.*;

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        // Step 1: Identify all rows and columns that should be zero
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        // Step 2: Set the cells to zero based on identified rows and columns
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row.contains(i) || col.contains(j)) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][][] testCases = {
                {
                        { 1, 1, 1 },
                        { 1, 0, 1 },
                        { 1, 1, 1 }
                },
                {
                        { 0, 1, 2, 0 },
                        { 3, 4, 5, 2 },
                        { 1, 3, 1, 5 }
                },
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 0, 8, 9 }
                }
        };

        int testCaseNum = 1;
        for (int[][] testCase : testCases) {
            System.out.println("Test Case " + testCaseNum++ + ":");
            System.out.println("Original Matrix:");
            printMatrix(testCase);

            sol.setMatrixZeroes(testCase);

            System.out.println("Matrix After setMatrixZeroes:");
            printMatrix(testCase);
            System.out.println("---------------------------------------");
        }
    }
}
