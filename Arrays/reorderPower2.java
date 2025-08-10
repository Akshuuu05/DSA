package Arrays;

import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortedString(n);
        for (int i = 0; i < 31; i++) {
            if (sortedString(1 << i).equals(target))
                return true;
        }
        return false;
    }

    private String sortedString(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] tests = { 1, 10, 16, 24, 46, 125, 128, 256, 1024 };
        for (int n : tests) {
            System.out.println(n + " → " + sol.reorderedPowerOf2(n));
        }
    }
}
