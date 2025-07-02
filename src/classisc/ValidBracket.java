package classisc;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidBracket {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                char cur = stack.pop();
                if ((s.charAt(i) == ')' && cur != '(') || (s.charAt(i) == ']' && cur != '[') || (s.charAt(i) == '}' && cur != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
