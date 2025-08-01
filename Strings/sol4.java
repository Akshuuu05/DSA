package Strings;

import java.util.*;

public class sol4 {

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }

    private int countDiff(String s) {
        int v = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch))
                v++;
            else
                c++;
        }
        return v - c;
    }

    public int countBalanced(String[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to count balanced subarrays starting from index 0
        int sum = 0, ans = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += countDiff(arr[i]);
            if (map.containsKey(sum)) {
                ans += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        sol4 sol = new sol4();

        String[] arr1 = { "a", "b", "ae", "cd" }; // Expected: 2
        String[] arr2 = { "aeiou", "bcdfg", "aeiou", "bcdfg" }; // Expected: 4
        String[] arr3 = { "ab", "cd", "ef" }; // Expected: 1
        String[] arr4 = { "abc", "de", "fgh", "i" }; // Expected: 1
        String[] arr5 = { "ae", "ae", "bc", "bc" }; // Expected: 4

        System.out.println("Test 1: " + sol.countBalanced(arr1)); // 2
        System.out.println("Test 2: " + sol.countBalanced(arr2)); // 4
        System.out.println("Test 3: " + sol.countBalanced(arr3)); // 1
        System.out.println("Test 4: " + sol.countBalanced(arr4)); // 1
        System.out.println("Test 5: " + sol.countBalanced(arr5)); // 4
    }
}
