package Arrays;

class Solution {
    public int countRevPairs(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] a, int l, int r) {
        if (l >= r)
            return 0;
        int m = l + (r - l) / 2;
        int count = mergeSort(a, l, m) + mergeSort(a, m + 1, r);

        // Count reverse pairs across halves
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) a[i] > 2L * (long) a[j])
                j++;
            count += (j - (m + 1));
        }

        // Merge the two sorted halves
        merge(a, l, m, r);
        return count;
    }

    private void merge(int[] a, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= m)
            temp[k++] = a[i++];
        while (j <= r)
            temp[k++] = a[j++];

        System.arraycopy(temp, 0, a, l, temp.length);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 3, 2, 3, 1 };
        System.out.println(sol.countRevPairs(arr1)); // Expected: 2

        int[] arr2 = { 2, 4, 3, 5, 1 };
        System.out.println(sol.countRevPairs(arr2)); // Expected: 3

        int[] arr3 = { 5, 4, 3, 2, 1 };
        System.out.println(sol.countRevPairs(arr3)); // Expected: many

        int[] arr4 = { 1, 2, 3, 4, 5 };
        System.out.println(sol.countRevPairs(arr4)); // Expected: 0
    }
}
