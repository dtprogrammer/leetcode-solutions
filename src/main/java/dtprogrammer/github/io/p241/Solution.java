package dtprogrammer.github.io.p241;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String leftOperand = input.substring(0, i);
                String rightOperand = input.substring(i + 1);

                List<Integer> leftWays = diffWaysToCompute(leftOperand);
                List<Integer> rightWays = diffWaysToCompute(rightOperand);


                for (int leftOp : leftWays) {
                    for (int rightOp : rightWays) {
                        int curResult = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                curResult = leftOp + rightOp;
                                break;
                            case '-':
                                curResult = leftOp - rightOp;
                                break;
                            case '*':
                                curResult = leftOp * rightOp;
                                break;
                        }
                        result.add(curResult);
                    }
                }

            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
