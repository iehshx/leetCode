package evalRPN;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        String[] stack = new String[tokens.length];
        int size = 0;
        for (String token : tokens) {
            if (!isEval(token)) {
                stack[size++] = token;
            } else {
                int value = eval(stack, size, token);
                size--;
                size--;
                stack[size++] = (value + "");
            }
        }

        return Integer.parseInt(stack[0]);
    }

    private int eval(String[] stack, int size, String token) {
        int ret = 0;
        int number1 = Integer.parseInt(stack[--size]);
        int number2 = Integer.parseInt(stack[--size]);
        switch (token) {
            case "+":
                ret = number2 + number1;
                break;
            case "-":
                ret = number2 - number1;
                break;
            case "*":
                ret = number2 * number1;
                break;
            case "/":
                ret = number2 / number1;
                break;
        }
        return ret;
    }

    private boolean isEval(String token) {
        return Objects.equals(token, "+") || Objects.equals(token, "-") || Objects.equals(token, "*") || Objects.equals(token, "/");
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}