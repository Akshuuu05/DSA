package Arrays;

class Solution {
    public boolean isPowerOfFour(int n) {
        // (n & (n - 1)) == 0 → ensures n is a power of 2
        // n % 3 == 1 → only powers of 4 among powers of 2 satisfy this
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isPowerOfFour(1)); // true (4^0)
        System.out.println(sol.isPowerOfFour(4)); // true (4^1)
        System.out.println(sol.isPowerOfFour(16)); // true (4^2)
        System.out.println(sol.isPowerOfFour(64)); // true (4^3)
        System.out.println(sol.isPowerOfFour(8)); // false
        System.out.println(sol.isPowerOfFour(0)); // false
        System.out.println(sol.isPowerOfFour(-4)); // false
    }
}
