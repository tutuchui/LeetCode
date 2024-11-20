package graduate;

import java.util.Stack;

public class EvalPRN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int num1;
        int num2;
        int result;
        for (String cur : tokens) {
            switch (cur) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 + num2;
                    stack.push(result);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 - num1;
                    stack.push(result);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 * num2;
                    stack.push(result);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 / num1;
                    stack.push(result);
                    break;
                default:
                    int num = Integer.valueOf(cur);
                    stack.push(num);
                    break;

            }
        }
        return stack.peek();
    }
}
