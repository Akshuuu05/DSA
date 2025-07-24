package Arrays;

/*We have a wooden plank of length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second, with some moving left and others right.
When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time. When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to the left and the right, return the time when the last ant(s) fall out of the plank.
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;

        for (int i : left) {
            ans = Math.max(ans, i);
        }

        for (int i : right) {
            ans = Math.max(ans, n - i);
        }

        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 4;
        int[] left1 = { 2 };
        int[] right1 = { 0, 1, 3 };
        System.out.println("Output 1: " + sol.getLastMoment(n1, left1, right1)); // Expected: 4

        int n2 = 4;
        int[] left2 = {};
        int[] right2 = { 0, 1, 2, 3, 4 };
        System.out.println("Output 2: " + sol.getLastMoment(n2, left2, right2)); // Expected: 4

        int n3 = 3;
        int[] left3 = { 0 };
        int[] right3 = { 3 };
        System.out.println("Output 3: " + sol.getLastMoment(n3, left3, right3)); // Expected: 0

        int n4 = 7;
        int[] left4 = { 0, 1, 3 };
        int[] right4 = { 6 };
        System.out.println("Output 4: " + sol.getLastMoment(n4, left4, right4)); // Expected: 4
    }
}
