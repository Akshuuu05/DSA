package Arrays;

class Solution {
    public String largestGoodInteger(String num) {
        String best = "";
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triple = num.substring(i, i + 3);
                if (best.compareTo(triple) < 0) {
                    best = triple;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.largestGoodInteger("6777133339")); // Expected: 777
        System.out.println(sol.largestGoodInteger("2300019")); // Expected: 000
        System.out.println(sol.largestGoodInteger("42352338")); // Expected: ""
        System.out.println(sol.largestGoodInteger("999111222")); // Expected: 999
    }
}
