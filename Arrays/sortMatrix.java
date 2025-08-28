package Arrays;

import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();
        int rows = matrix.length, cols = matrix[0].length;

        // Store each element in its diagonal heap
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                diagonalMap.putIfAbsent(key, key < 0 ? new PriorityQueue<>()
                        : new PriorityQueue<>(Collections.reverseOrder()));
                diagonalMap.get(key).offer(matrix[i][j]);
            }
        }

        // Refill matrix from heaps
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                matrix[i][j] = diagonalMap.get(key).poll();
            }
        }

        return matrix;
    }

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
                { 3, 3, 1, 1 },
                { 2, 2, 1, 2 },
                { 1, 1, 1, 2 }
        };

        System.out.println("Original Matrix:");
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }

        int[][] sorted = sol.sortMatrix(mat);

        System.out.println("\nSorted Matrix:");
        for (int[] row : sorted) {
            System.out.println(Arrays.toString(row));
        }
    }
}
