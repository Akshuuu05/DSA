package Arrays;
//import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, ans = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans - 1; // because we must delete one element
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
        System.out.println("Test 1: " + sol.longestSubarray(nums1)); // Expected 5

        int[] nums2 = { 1, 1, 1 };
        System.out.println("Test 2: " + sol.longestSubarray(nums2)); // Expected 2

        int[] nums3 = { 0, 0, 0 };
        System.out.println("Test 3: " + sol.longestSubarray(nums3)); // Expected 0

        int[] nums4 = { 1, 0, 1, 1, 0, 1 };
        System.out.println("Test 4: " + sol.longestSubarray(nums4)); // Expected 3

        int[] nums5 = { 1, 1, 0, 1 };
        System.out.println("Test 5: " + sol.longestSubarray(nums5)); // Expected 3
    }
}
