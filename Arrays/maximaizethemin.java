package Arrays;

import java.util.*;

class Solution {
    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 0, high = arr[arr.length - 1] - arr[0], ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2, count = 1, last = arr[0];
            for (int i = 1; i < arr.length && count < k; i++) {
                if (arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }
            if (count >= k) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 2, 8, 4, 9 };
        System.out.println(sol.maxMinDiff(arr1, 3)); // 3 (pick 1,4,8 or 1,4,9)

        int[] arr2 = { 1, 3, 7, 9, 13 };
        System.out.println(sol.maxMinDiff(arr2, 3)); // 6 (pick 1,7,13)

        int[] arr3 = { 5, 4, 3, 2, 1 };
        System.out.println(sol.maxMinDiff(arr3, 2)); // 4 (pick 1 and 5)

        int[] arr4 = { 10, 20, 30, 40, 50 };
        System.out.println(sol.maxMinDiff(arr4, 3)); // 20 (pick 10,30,50)
    }
}
