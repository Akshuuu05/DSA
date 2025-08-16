package Arrays;

class Solution {
    public int maximum69Number(int num) {
        // Replace the first occurrence of '6' with '9'
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maximum69Number(9669)); // Expected: 9969
        System.out.println(sol.maximum69Number(9996)); // Expected: 9999
        System.out.println(sol.maximum69Number(9999)); // Expected: 9999
        System.out.println(sol.maximum69Number(6969)); // Expected: 9969
        System.out.println(sol.maximum69Number(6)); // Expected: 9
    }
}
