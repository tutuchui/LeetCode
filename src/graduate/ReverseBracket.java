package graduate;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ReverseBracket {
    static String resolve(String expr) {
        Stack<Character> bracket = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        HashSet<Integer> bracketIndex = new HashSet<>();
        StringBuilder result = new StringBuilder(expr);
        for(int i = 0; i < result.length();i++){
            char currentChar = result.charAt(i);
            if(currentChar == '('){
                bracket.push(currentChar);
                indexStack.push(i);
            }else if(currentChar == ')'){
                if(bracket.isEmpty()){
                    return "";
                }
                bracket.pop();
                int start = indexStack.pop();
                String revString = reverseString(result.substring(start,i + 1));
                int j = 0;
                for(int k = start; k < i + 1; k++){
                    result.setCharAt(k,revString.charAt(j));
                    j++;
                }
            }
        }
        StringBuilder resultExp = new StringBuilder();
        for(int i = 0; i < result.length();i++){
            if(result.charAt(i)!='('&&result.charAt(i)!=')'){
                resultExp.append(result.charAt(i));
            }
        }
        return resultExp.toString();

    }

    static String reverseString(String s){
        StringBuilder newString = new StringBuilder();
        for(int i = s.length() - 1; i>= 0;i--){
            newString.append(s.charAt(i));
        }
        return newString.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
//        System.out.println(reverseString("((ru)oi)"));
//        String expr = "123456";
//        System.out.println(expr.substring(0,0));
    }
}
