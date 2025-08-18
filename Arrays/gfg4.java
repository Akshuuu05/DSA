package Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int high = Integer.MIN_VALUE;
        int low = 0;

        // Find the max citation value
        for (int num : citations) {
            if (num > high)
                high = num;
        }

        // Binary search for max h
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(citations, mid, n)) {
                low = mid + 1; // try bigger h
            } else {
                high = mid - 1; // decrease h
            }
        }

        return high;
    }

    public boolean isPossible(int[] citations, int val, int n) {
        int cnt = 0;
        for (int num : citations) {
            if (num >= val)
                cnt++;
        }
        return cnt >= val;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 3, 0, 6, 1, 5 };
        System.out.println(sol.hIndex(arr1)); // Expected: 3

        int[] arr2 = { 1, 3, 1 };
        System.out.println(sol.hIndex(arr2)); // Expected: 1

        int[] arr3 = { 0, 0, 0 };
        System.out.println(sol.hIndex(arr3)); // Expected: 0

        int[] arr4 = { 100 };
        System.out.println(sol.hIndex(arr4)); // Expected: 1
    }
}
