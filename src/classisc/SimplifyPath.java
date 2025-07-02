package classisc;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for(String curPath : paths) {
            if(curPath.isEmpty()) {
                continue;
            }
            if(curPath.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if(!curPath.equals(".")) {
                stack.push(curPath);
            }
        }
        StringBuilder res = new StringBuilder();
        if(stack.isEmpty()) {
            res.append("/");
        }
        for(String curPath : stack) {
            res.append("/").append(curPath);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/../"));
    }
}
