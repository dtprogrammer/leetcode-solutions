package dtprogrammer.github.io.p215;

import java.util.Random;

/**
 * <h1>Problem</h1>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ? k ? array's length.
 * <p>
 * <p>
 * <h1>Solution</h1>
 * We can use <b>quick-select</b> to solve this problem. We use the parition method of the quick sort algorithm but
 * rather than recursing to solve the sub problem we just find the correct position of the pivot
 * <h3>Time complexity</h3>
 * The time complexity of this in average case will be O(n) the complexity of the parition method in quick sort
 * although in worst case it will be O(n<sup>2</sup>). This can be optimized to almost gurantee O(n) by randomizing
 * the given input. See {@link #shuffleInput(int[])}
 * <h3>Space complexity</h3>
 * O(1)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffleInput(nums);
        int low = 0;
        int high = nums.length - 1;
        int kLargestIndex = nums.length - k;

        while (low < high) {
            int curPosition = partition(nums, low, high);
            if (curPosition < kLargestIndex) {
                low = curPosition + 1;
            } else if (curPosition > kLargestIndex) {
                high = curPosition - 1;
            } else {
                break;
            }
        }
        return nums[kLargestIndex];
    }

    private int partition(int[] nums, int start, int end) {
        int less = start - 1;
        int pivot = nums[end];

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                less = less + 1;
                swap(nums, i, less);
            }
        }
        swap(nums, less + 1, end);
        return less + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void shuffleInput(int[] nums) {
        // shuffle the array with Fisher-Yates algorithm complexity O(n)
        Random random = new Random();

        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i);
            swap(nums, i, j);
        }
    }
}
