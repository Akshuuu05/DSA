package Arrays;

import java.util.*;

class Solution {
    final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int n : cards)
            nums.add((double) n);
        return dfs(nums);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPS;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j)
                        next.add(nums.get(k));
                }

                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (dfs(next))
                        return true;
                    next.remove(next.size() - 1); // backtrack
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS)
            res.add(a / b);
        if (Math.abs(a) > EPS)
            res.add(b / a);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] cards1 = { 4, 1, 8, 7 };
        System.out.println(sol.judgePoint24(cards1)); // true (8 * (3) = 24)

        int[] cards2 = { 1, 2, 1, 2 };
        System.out.println(sol.judgePoint24(cards2)); // false

        int[] cards3 = { 3, 3, 8, 8 };
        System.out.println(sol.judgePoint24(cards3)); // true

        int[] cards4 = { 7, 7, 3, 3 };
        System.out.println(sol.judgePoint24(cards4)); // true
    }
}
