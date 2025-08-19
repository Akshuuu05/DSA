package Arrays;

import java.util.*;

class Solution {
    int n;
    int[] segTree;

    // Build segment tree storing index of max element in arr
    public void makeTree(int ind, int start, int end, int[] arr) {
        if (start == end) {
            segTree[ind] = start;
            return;
        }

        int mid = start + (end - start) / 2;
        makeTree(2 * ind + 1, start, mid, arr);
        makeTree(2 * ind + 2, mid + 1, end, arr);

        // store index of maximum element
        int leftIndex = segTree[2 * ind + 1];
        int rightIndex = segTree[2 * ind + 2];
        segTree[ind] = arr[leftIndex] >= arr[rightIndex] ? leftIndex : rightIndex;
    }

    // Query for first index in [fs, fe] where arr[j] < limit
    public int query(int ind, int s, int e, int[] arr, int fs, int fe, int limit) {
        if (fe < s || e < fs)
            return -1; // out of range
        if (arr[segTree[ind]] >= limit)
            return -1; // all values >= limit

        if (s == e)
            return s; // leaf node, valid index

        int mid = s + (e - s) / 2;

        // Try left child first (to ensure closest index)
        int leftAns = query(2 * ind + 1, s, mid, arr, fs, fe, limit);
        if (leftAns != -1)
            return leftAns;

        return query(2 * ind + 2, mid + 1, e, arr, fs, fe, limit);
    }

    public ArrayList<Integer> farMin(int[] arr) {
        n = arr.length;
        segTree = new int[n * 4];
        makeTree(0, 0, n - 1, arr);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int qAns = -1;
            if (i + 1 < n) {
                qAns = query(0, 0, n - 1, arr, i + 1, n - 1, arr[i]);
            }
            ans.add(qAns);
        }
        return ans;
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 5, 3, 8, 2, 6, 1 };
        System.out.println(sol.farMin(arr));
        // Expected: [1, 3, 3, 5, 5, -1]
    }
}
