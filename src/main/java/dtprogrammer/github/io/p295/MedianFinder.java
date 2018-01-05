package dtprogrammer.github.io.p295;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class MedianFinder {

    Queue<Integer> low;
    Queue<Integer> hi;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        low = new PriorityQueue<>((o1, o2) -> o2 - o1);
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        low.add(num);
        hi.add(low.poll());

        // balance the size
        if (low.size() < hi.size()) {
            low.add(hi.poll());
        }
    }

    public double findMedian() {
        return low.size() > hi.size() ? low.peek() : (hi.peek() + low.peek()) / 2.0;
    }
}
