package Arrays;

import java.util.PriorityQueue;

public class mindiff {
    public long minimumDifference(int[] nums) {
        int n = nums.length, k = n / 3;
        long[] leftMins = new long[n]; // sum of k smallest from left
        long[] rightMaxs = new long[n]; // sum of k largest from right
        long leftSum = 0, rightSum = 0, minDiff = Long.MAX_VALUE;

        PriorityQueue<Integer> maxLeftHeap = new PriorityQueue<>((a, b) -> b - a); // max-heap
        PriorityQueue<Integer> minRightHeap = new PriorityQueue<>(); // min-heap

        // Build leftMins
        for (int i = 0; i < k; i++) {
            maxLeftHeap.offer(nums[i]);
            leftSum += nums[i];
        }
        leftMins[k - 1] = leftSum;

        for (int i = k; i < n - k; i++) {
            int x = nums[i];
            if (x < maxLeftHeap.peek()) {
                leftSum += x - maxLeftHeap.poll();
                maxLeftHeap.offer(x);
            }
            leftMins[i] = leftSum;
        }

        // Build rightMaxs
        for (int i = n - 1; i >= n - k; i--) {
            minRightHeap.offer(nums[i]);
            rightSum += nums[i];
        }
        rightMaxs[n - k] = rightSum;

        for (int i = n - k - 1; i >= k - 1; i--) {
            int x = nums[i];
            if (x > minRightHeap.peek()) {
                rightSum += x - minRightHeap.poll();
                minRightHeap.offer(x);
            }
            rightMaxs[i] = rightSum;
        }

        // Find minimum difference
        for (int i = k - 1; i < n - k; i++) {
            minDiff = Math.min(minDiff, leftMins[i] - rightMaxs[i + 1]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        mindiff calculator = new mindiff();

        // Sample test case
        int[] nums = { 1, 3, 5, 2, 8, 7, 4, 6, 9 }; // Example array of length 9 (divisible by 3)

        long result = calculator.minimumDifference(nums);
        System.out.println("Minimum Difference: " + result);
    }
}
