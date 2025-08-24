package Arrays;
//import java.util.*;

class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        if ((long) m * k > n)
            return -1; // Not enough flowers

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : arr) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMake(arr, mid, m, k)) {
                ans = mid;
                right = mid - 1; // Try earlier days
            } else {
                left = mid + 1; // Need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int day, int m, int k) {
        int bouquets = 0, count = 0;
        for (int bloom : arr) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; // reset after making bouquet
                }
            } else {
                count = 0; // break adjacency
            }
            if (bouquets >= m)
                return true;
        }
        return false;
    }

    // Main function with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] flowers1 = { 1, 10, 3, 10, 2 };
        System.out.println("Test 1: " + sol.minDaysBloom(flowers1, 3, 1)); // Expected 3

        int[] flowers2 = { 1, 10, 3, 10, 2 };
        System.out.println("Test 2: " + sol.minDaysBloom(flowers2, 3, 2)); // Expected -1

        int[] flowers3 = { 7, 7, 7, 7, 12, 7, 7 };
        System.out.println("Test 3: " + sol.minDaysBloom(flowers3, 3, 2)); // Expected 12

        int[] flowers4 = { 1000000000, 1000000000 };
        System.out.println("Test 4: " + sol.minDaysBloom(flowers4, 1, 2)); // Expected 1000000000

        int[] flowers5 = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
        System.out.println("Test 5: " + sol.minDaysBloom(flowers5, 2, 4)); // Expected 9
    }
}
