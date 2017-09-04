package dtprogrammer.github.io.p20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
 * string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Time complexity: O (n)
 * Space complexity: O (1)
 */
public class Solution {

    private static final Map<Character, Character> BRACE_PAIR = new HashMap<>();

    static {
        BRACE_PAIR.put('}', '{');
        BRACE_PAIR.put(')', '(');
        BRACE_PAIR.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!(BRACE_PAIR.containsKey(s.charAt(i)) && !stack.isEmpty() &&
                    BRACE_PAIR.get(s.charAt(i)) == stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
