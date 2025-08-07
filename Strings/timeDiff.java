package Strings;

import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int[] timeInSeconds = new int[arr.length];

        // Convert each time to seconds
        for (int i = 0; i < arr.length; i++) {
            String[] parts = arr[i].split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            timeInSeconds[i] = hours * 3600 + minutes * 60 + seconds;
        }

        // Sort the array
        Arrays.sort(timeInSeconds);

        int minDiff = Integer.MAX_VALUE;
        int n = timeInSeconds.length;

        // Compare adjacent times
        for (int i = 0; i < n - 1; i++) {
            int diff = timeInSeconds[i + 1] - timeInSeconds[i];
            minDiff = Math.min(minDiff, diff);
        }

        // Handle wrap-around (last → first, next day)
        int lastToFirst = (86400 - timeInSeconds[n - 1]) + timeInSeconds[0];
        minDiff = Math.min(minDiff, lastToFirst);

        return minDiff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] times1 = { "23:59:59", "00:00:01", "12:00:00" };
        String[] times2 = { "00:00:10", "00:00:30", "00:00:20" };
        String[] times3 = { "12:30:45", "12:31:00", "12:32:00" };

        System.out.println("Min Difference 1: " + sol.minDifference(times1)); // Expected: 2
        System.out.println("Min Difference 2: " + sol.minDifference(times2)); // Expected: 10
        System.out.println("Min Difference 3: " + sol.minDifference(times3)); // Expected: 15
    }
}
