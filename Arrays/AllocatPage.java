package Arrays;

import java.util.*;

class Solution {
    public static int countStudent(int[] arr, int pages) {
        int students = 1;
        int studentPages = 0;
        for (int num : arr) {
            if (studentPages + num <= pages) {
                studentPages += num;
            } else {
                students++;
                studentPages = num;
            }
        }
        return students;
    }

    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;

        int low = Arrays.stream(arr).max().getAsInt(); // max book
        int high = Arrays.stream(arr).sum(); // sum of all books

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countStudent(arr, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // 🔹 Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] books1 = { 12, 34, 67, 90 };
        System.out.println(sol.findPages(books1, 2)); // Expected: 113

        int[] books2 = { 10, 20, 30, 40 };
        System.out.println(sol.findPages(books2, 2)); // Expected: 60

        int[] books3 = { 5, 17, 100, 11 };
        System.out.println(sol.findPages(books3, 4)); // Expected: 100
    }
}
