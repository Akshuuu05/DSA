package Arrays;

class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^19 = 1162261467 is the largest power of 3 within int range
        int maxPowerOf3 = 1162261467;

        // If n is positive and divides maxPowerOf3 evenly, then it's a power of 3
        return n > 0 && maxPowerOf3 % n == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] testNumbers = { 1, 3, 9, 27, 81, 243, 0, -3, 45, 1162261467 };

        for (int num : testNumbers) {
            System.out.println("Is " + num + " a power of three? " + sol.isPowerOfThree(num));
        }
    }
}
