package dtprogrammer.github.io.p227;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * http://dtprogrammer.github.io/227-basic-calculator-ii/
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0, num = 0, op = '+'; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // i == s.length() - 1 is needed to do the operation for the operand
            if ("+-/*".indexOf(c) >= 0 || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        result -= stack.peek();
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        result -= stack.peek();
                        stack.push(stack.pop() / num);
                        break;
                }
                result += stack.peek();
                num = 0;
                op = c;
            }
        }
        return result;
    }
}
