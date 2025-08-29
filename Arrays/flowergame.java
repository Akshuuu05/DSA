package Arrays;

class Solution {
    public long flowerGame(int n, int m) {
        return ((long) m * n) / 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 3, m = 4; // example values
        long result = sol.flowerGame(n, m);

        System.out.println("For n = " + n + ", m = " + m + " -> Result = " + result);

    }
}
