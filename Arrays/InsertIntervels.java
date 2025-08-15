package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] intervals1 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = { 2, 5 };
        printResult(sol.insertInterval(intervals1, newInterval1));
        // Expected: [[1,5],[6,9]]

        int[][] intervals2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = { 4, 8 };
        printResult(sol.insertInterval(intervals2, newInterval2));
        // Expected: [[1,2],[3,10],[12,16]]

        int[][] intervals3 = {};
        int[] newInterval3 = { 5, 7 };
        printResult(sol.insertInterval(intervals3, newInterval3));
        // Expected: [[5,7]]
    }

    private static void printResult(ArrayList<int[]> result) {
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}
