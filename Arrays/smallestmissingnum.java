package Arrays;

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int actualSum = 0;

        // Find min, max, and actual sum
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            actualSum += num;
        }

        // Total elements expected if one number is missing
        int expectedCount = max - min + 1;

        // If only one number is missing
        if (expectedCount - 1 == n) {
            int expectedSum = (expectedCount * (min + max)) / 2;
            return expectedSum - actualSum;
        }

        // If more than one number is missing or duplicate exists
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 3, 7, 5, 4 }; // Missing number should be 6
        System.out.println("Missing Number: " + sol.missingNumber(arr));
    }
}
