package Arrays;

public class Solution {

    int lcmTriplets(int n) {
        // Return the maximum LCM of any triplet (a, b, c) such that 1 <= a < b < c <= n
        if (n <= 2)
            return n;

        if ((n & 1) == 1)
            return (n - 2) * (n - 1) * n;

        if (n % 3 == 0)
            return (n - 2) * (n - 1) * (n - 3);

        return (n - 3) * (n - 1) * n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample test cases
        int[] testCases = { 1, 2, 5, 6, 7, 10, 12, 15 };

        for (int n : testCases) {
            int result = sol.lcmTriplets(n);
            System.out.println("Max LCM triplet product for n = " + n + " is: " + result);
        }
    }
}
