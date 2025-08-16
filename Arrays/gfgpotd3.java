package Arrays;

import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        String[] strarr = new String[arr.length];

        // Convert integers to strings
        for (int i = 0; i < arr.length; i++) {
            strarr[i] = String.valueOf(arr[i]);
        }

        // Sort using custom comparator
        Arrays.sort(strarr, (a, b) -> (b + a).compareTo(a + b));

        // If highest number is "0", result is just "0"
        if (strarr[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder str = new StringBuilder();
        for (String s : strarr) {
            str.append(s);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 10, 2 };
        System.out.println(sol.findLargest(arr1)); // Expected: "210"

        int[] arr2 = { 3, 30, 34, 5, 9 };
        System.out.println(sol.findLargest(arr2)); // Expected: "9534330"

        int[] arr3 = { 0, 0 };
        System.out.println(sol.findLargest(arr3)); // Expected: "0"

        int[] arr4 = { 54, 546, 548, 60 };
        System.out.println(sol.findLargest(arr4)); // Expected: "6054854654"
    }
}
