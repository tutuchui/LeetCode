import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push((int)Double.POSITIVE_INFINITY);
    }

    public void push(int x){
        stack.push(x);
        if(x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
