package graduate;

import java.util.Stack;

public class IsValidBracket {
    public boolean isValidBracket(String s){
        if (s.equals("")) {
            return  true;
        }
        if(s.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack();
        char[] strC = s.toCharArray();
        for(char c : strC){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(c == ')' && stack.pop()!= '('){
                    return false;
                }
                if(c == ']' && stack.pop()!= '['){
                    return false;
                }
                if(c == '}' && stack.pop()!= '{'){
                    return false;
                }
            }
        }
        return true;
    }
}
