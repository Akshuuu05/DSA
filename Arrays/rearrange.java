package Arrays;

import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert to Integer[] because Arrays.sort with comparator
        // doesn’t work directly on primitive int[]
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort by closeness to x
        Arrays.sort(temp, (a, b) -> Math.abs(a - x) - Math.abs(b - x));

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 10, 5, 3, 9, 2 };
        sol.rearrange(arr1, 7);
        System.out.println(Arrays.toString(arr1));
        // Expected: [9, 5, 10, 3, 2] (order may vary for equal distances)

        int[] arr2 = { 1, 2, 3, 4, 5 };
        sol.rearrange(arr2, 3);
        System.out.println(Arrays.toString(arr2));
        // Expected: [3, 2, 4, 1, 5]

        int[] arr3 = { 100, 90, 80, 70 };
        sol.rearrange(arr3, 85);
        System.out.println(Arrays.toString(arr3));
        // Expected: [90, 80, 100, 70]
    }
}
