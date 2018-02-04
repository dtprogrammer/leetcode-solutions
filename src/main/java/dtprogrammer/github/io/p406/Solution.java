package dtprogrammer.github.io.p406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 * <p>
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * <p>
 * Pick out tallest group of people and sort them in a subarray (S). Since there’s no other groups of people taller
 * than them, therefore each guy’s index will be just as same as his k value.
 * For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
 * <p>
 * Time complexity: O(nLog(n)) to sort + O(n ^ 2) to insert in the linked list.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort the queue with people height in descending order and if the height is same then
        // sort then in ascending order of their position
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
