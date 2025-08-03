package Arrays;

import java.util.*;

class Solution {

    public static void helper(int[][] mat, int v, int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                mat[i][j] += v;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < opr.length; i++) {
            helper(mat, opr[i][0], opr[i][1], opr[i][2], opr[i][3], opr[i][4]);
        }

        for (int i = 0; i < mat.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < mat[0].length; j++) {
                row.add(mat[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    // Sample usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Each op = {v, r1, c1, r2, c2}
        int[][] opr = {
                { 10, 0, 0, 1, 1 },
                { -2, 1, 1, 2, 2 }
        };

        ArrayList<ArrayList<Integer>> result = sol.applyDiff2D(mat, opr);

        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}
