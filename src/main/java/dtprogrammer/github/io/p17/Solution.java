package dtprogrammer.github.io.p17;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * <p>
 * Time complexity: Its easy to see how the time complexity if at least O (n pow 2) since we generate combination for
 * every
 * part of n with other although a digit has 4 letter at max. so its O(4 * n pow 2)
 * Space Complexity: O (k pow n) where k is number of alphabets associated with a number which here is max 4n
 * although this is what we are using to store the result too so it doesn't actually counts
 */
public class Solution {

    private static final String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String partial = result.remove();
                for (char c : letters[index].toCharArray()) {
                    result.add(partial + c);
                }
            }
        }
        return result;
    }
}
