package Arrays;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, numSubarray = 0;
        for (int num : nums) {
            if (num == 0)
                numSubarray++;
            else
                numSubarray = 0;
            ans += numSubarray;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.zeroFilledSubarray(new int[] { 1, 3, 0, 0, 2, 0, 0, 4 })); // 6
        System.out.println(sol.zeroFilledSubarray(new int[] { 0, 0, 0, 2, 0, 0 })); // 9
        System.out.println(sol.zeroFilledSubarray(new int[] { 2, 10, 2019 })); // 0
    }
}
