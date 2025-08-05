package Strings;

class Solution {

    public boolean isChar(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return true;
        if (ch >= 'A' && ch <= 'Z')
            return true;
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }

    public boolean isPalinSent(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (!isChar(s.charAt(i))) {
                i++;
            } else if (!isChar(s.charAt(j))) {
                j--;
            } else {
                char t1 = Character.toLowerCase(s.charAt(i));
                char t2 = Character.toLowerCase(s.charAt(j));
                if (t1 != t2) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "No lemon, no melon";

        System.out.println("Is palindrome: " + sol.isPalinSent(s1)); // true
        System.out.println("Is palindrome: " + sol.isPalinSent(s2)); // false
        System.out.println("Is palindrome: " + sol.isPalinSent(s3)); // true
    }
}
