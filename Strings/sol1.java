package Strings;

public class sol1 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mult = d1 * d2;
                int sum = mult + pos[i + j + 1];

                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }

        // Build the final result string
        StringBuilder res = new StringBuilder();
        for (int p : pos) {
            if (res.length() == 0 && p == 0)
                continue; // skip leading zeros
            res.append(p);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        System.out.println(multiply(num1, num2)); // Output: "5535"
    }
}
