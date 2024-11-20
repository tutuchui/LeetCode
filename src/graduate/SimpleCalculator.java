package graduate;

import java.util.Stack;

//Leetcode 224
public class SimpleCalculator {
    public int calculate(String s){
        int n = s.length();
        int i = 0;
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        int sign = 1;
        int result = 0;
        while (i < n){
            if(s.charAt(i) == ' '){
                i++;
            } else if(s.charAt(i) == '+'){
                sign = ops.peek();
                i++;
            }else if(s.charAt(i) == '-'){
                sign = -ops.peek();
                i++;
            }else if(s.charAt(i) == '('){
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == ')'){
                ops.pop();
                i++;
            }else{
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}
