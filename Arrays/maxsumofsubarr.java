package Arrays;

import java.util.HashSet;
import java.util.Set;

public class maxsumofsubarr {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        // HashSet to track unique elements in the current window
        Set<Integer> set = new HashSet<>();

        int ans = 0;
        int sum = 0; // Sum of current window
        int first = 0; // Left pointer of the window

        for (int sec = 0; sec < n; sec++) { // sec is the right pointer
            // If duplicate is found, shrink window from the left
            while (set.contains(nums[sec])) {
                sum -= nums[first];
                set.remove(nums[first]);
                first++;
            }

            // Add current element to window
            sum += nums[sec];
            set.add(nums[sec]);

            // Update max sum
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
