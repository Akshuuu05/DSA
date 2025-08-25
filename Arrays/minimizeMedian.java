package Arrays;

import java.util.*;

class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int medianIndex = (n - 1) / 2;
        int current = arr[medianIndex];

        for (int i = medianIndex; i < n - 1 && k > 0; i++) {
            int gap = arr[i + 1] - arr[i];
            int count = (i - medianIndex + 1);

            int needed = gap * count;
            if (k >= needed) {
                current = arr[i + 1];
                k -= needed;
            } else {
                current += k / count;
                k = 0;
            }
        }

        if (k > 0) {
            current += k / (n - medianIndex);
        }

        return current;
    }

    // 🔹 Main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 2, 3, 4, 5 };
        System.out.println(sol.maximizeMedian(arr1, 5)); // Expected 5

        int[] arr2 = { 2, 1, 5 };
        System.out.println(sol.maximizeMedian(arr2, 2)); // Expected 5

        int[] arr3 = { 1, 3, 3, 3 };
        System.out.println(sol.maximizeMedian(arr3, 4)); // Expected 4
    }
}
