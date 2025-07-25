package Arrays;

class Solution {
    public static int maxCircularSubarraySum(int[] arr) {
        int currMax = arr[0], maxSum = arr[0];
        int currMin = arr[0], minSum = arr[0];
        int totalSum = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(arr[i], currMin + arr[i]);
            minSum = Math.min(minSum, currMin);

            totalSum += arr[i];
        }

        // If all elements are negative, totalSum == minSum
        if (totalSum == minSum)
            return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }

    // Testing the function with given test cases
    public static void main(String[] args) {
        int[] arr1 = { 8, -8, 9, -9, 10, -11, 12 };
        int[] arr2 = { 10, -3, -4, 7, 6, 5, -4, -1 };
        int[] arr3 = { 5, -2, 3, 4 };

        System.out.println("Output 1: " + maxCircularSubarraySum(arr1)); // Expected: 22
        System.out.println("Output 2: " + maxCircularSubarraySum(arr2)); // Expected: 23
        System.out.println("Output 3: " + maxCircularSubarraySum(arr3)); // Expected: 12
    }
}
