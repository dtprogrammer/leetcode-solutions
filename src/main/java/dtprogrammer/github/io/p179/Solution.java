package dtprogrammer.github.io.p179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * http://dtprogrammer.github.io/179-largest-number/
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];

        // converts the numbers to string
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (o1, o2) -> {
            String firstOption = o1 + o2;
            String secondsOption = o2 + o1;
            return secondsOption.compareTo(firstOption);
        };

        Arrays.sort(numbers, comparator);
        if (numbers[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            builder.append(number);
        }
        return builder.toString();
    }
}
