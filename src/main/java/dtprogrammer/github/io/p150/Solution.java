package dtprogrammer.github.io.p150;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * http://dtprogrammer.github.io/150-evaluate-reverse-polish-notation/
 */
public class Solution {
    private static final Map<String, Integer> OPERATORS;

    static {
        Map<String, Integer> temp = new HashMap<>();
        temp.put("+", 1);
        temp.put("-", 2);
        temp.put("*", 3);
        temp.put("/", 4);
        OPERATORS = Collections.unmodifiableMap(temp);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (OPERATORS.containsKey(tokens[i])) {
                int operand2 = operands.pop();
                int operand1 = operands.pop();
                switch (OPERATORS.get(tokens[i])) {
                    case 1:
                        operands.push(operand1 + operand2);
                        break;
                    case 2:
                        operands.push(operand1 - operand2);
                        break;
                    case 3:
                        operands.push(operand1 * operand2);
                        break;
                    case 4:
                        operands.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }
            } else {
                operands.push(Integer.valueOf(tokens[i]));
            }
        }
        return operands.pop();
    }
}
