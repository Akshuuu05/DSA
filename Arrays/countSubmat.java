package Arrays;

import java.util.*;

class Solution {
    public int numSubmat(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] h = new int[c];
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                h[j] = (mat[i][j] == 0) ? 0 : h[j] + 1;
            }
            ans += count(h);
        }
        return ans;
    }

    private int count(int[] h) {
        int n = h.length, res = 0;
        int[] sum = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i])
                st.pop();

            if (!st.isEmpty()) {
                int p = st.peek();
                sum[i] = sum[p] + h[i] * (i - p);
            } else {
                sum[i] = h[i] * (i + 1);
            }

            st.push(i);
            res += sum[i];
        }
        return res;
    }

    // ------------------------------
    // Main function for testing
    // ------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat1 = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        System.out.println(sol.numSubmat(mat1)); // 13

        int[][] mat2 = {
                { 0, 1, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 0 }
        };
        System.out.println(sol.numSubmat(mat2)); // 24

        int[][] mat3 = {
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println(sol.numSubmat(mat3)); // 18

        int[][] mat4 = {
                { 0, 0 },
                { 0, 0 }
        };
        System.out.println(sol.numSubmat(mat4)); // 0
    }
}
