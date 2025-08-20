package Arrays;

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mat[mid / cols][mid % cols]; // map 1D index to 2D

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        System.out.println(sol.searchMatrix(matrix, 3)); // true
        System.out.println(sol.searchMatrix(matrix, 13)); // false
        System.out.println(sol.searchMatrix(matrix, 60)); // true
    }
}
