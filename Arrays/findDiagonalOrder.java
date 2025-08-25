package Arrays;

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        int idx = 0;

        for (int d = 0; d < n + m - 1; d++) { // fix: should be n+m-1
            List<Integer> temp = new ArrayList<>();
            int row = d < m ? 0 : d - m + 1;
            int col = d < m ? d : m - 1;

            while (row < n && col >= 0) {
                temp.add(mat[row][col]);
                row++;
                col--;
            }

            if (d % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int val : temp) {
                result[idx++] = val;
            }
        }

        return result;
    }

    // ✅ Main function for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[] result = sol.findDiagonalOrder(mat);

        System.out.println(Arrays.toString(result));
    }
}
