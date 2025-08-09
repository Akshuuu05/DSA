package Arrays;

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testNumbers = { 1, 2, 3, 4, 16, 18, 64, 100 };

        for (int num : testNumbers) {
            System.out.println(num + " is power of two? " + sol.isPowerOfTwo(num));
        }
    }
}
