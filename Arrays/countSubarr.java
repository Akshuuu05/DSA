package Arrays;

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            cnt += (arr[i] > k) ? 1 : -1;

            if (cnt > 0) {
                ans = i + 1; // full subarray from 0 to i is valid
            } else {
                if (map.containsKey(cnt - 1)) {
                    ans = Math.max(ans, i - map.get(cnt - 1));
                }
            }

            // store first occurrence only
            map.putIfAbsent(cnt, i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Elements > k are 3 and 4
        int[] arr1 = { 1, 3, 2, 4 };
        System.out.println("Test 1: " + sol.longestSubarray(arr1, 2)); // Expected: 3 ([3,2,4])

        // Test 2: All elements <= k
        int[] arr2 = { 1, 1, 1, 1 };
        System.out.println("Test 2: " + sol.longestSubarray(arr2, 1)); // Expected: 0

        // Test 3: Elements alternate around k
        int[] arr3 = { 2, 3, 2, 3, 2 };
        System.out.println("Test 3: " + sol.longestSubarray(arr3, 2)); // Expected: 5

        // Test 4: Long increasing sequence
        int[] arr4 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 4: " + sol.longestSubarray(arr4, 3)); // Expected: 2 ([4,5])

        // Test 5: Random mix
        int[] arr5 = { 4, 1, 5, 1, 6, 1, 7 };
        System.out.println("Test 5: " + sol.longestSubarray(arr5, 3)); // Expected: 5
    }

}
