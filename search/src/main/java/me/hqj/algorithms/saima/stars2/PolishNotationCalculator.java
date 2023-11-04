package me.hqj.algorithms.saima.stars2;

import java.util.Stack;

/**
 * 波兰式运算
 */
public class PolishNotationCalculator {
    public static void main(String[] args) {
//        String[] tokens = {"*", "+", "2", "1", "3"};
        String[] tokens = {"-", "+","+","+","*","3","4","2","1","/","*","5","6","2","8"};
        int result = evalPN(tokens);
        System.out.println("结果：" + result);
    }

    public static int evalPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        }

        throw new IllegalArgumentException("不支持的操作符: " + operator);
    }
}