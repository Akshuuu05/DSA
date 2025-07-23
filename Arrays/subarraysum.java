package Arrays;

class Solution {

    public int subarrSum(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            res += arr[i] * (i + 1) * (n - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 2, 3 };
        int result1 = sol.subarrSum(arr1);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + result1); // Expected: 20

        int[] arr2 = { 1, 3 };
        int result2 = sol.subarrSum(arr2);
        System.out.println("Input: [1, 3]");
        System.out.println("Output: " + result2);
    }
}
