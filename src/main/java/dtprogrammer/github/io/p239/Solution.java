package dtprogrammer.github.io.p239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * http://dtprogrammer.github.io/239-sliding-window-maximum/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 | k <= 0) {
            return new int[0];
        }

        // the result array
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // remove the numbers which have passed the window left boundary
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }

            // remove the numbers which are smaller than the current element and are in the window
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offer(i);
            // add to the result if window size has been reached
            if (i >= k - 1) {
                result[resultIndex++] = nums[window.peek()];
            }
        }
        return result;
    }
}
