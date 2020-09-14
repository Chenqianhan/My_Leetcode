package Interview;

import java.util.Stack;

public class OneFiftyFive_MinStack {
    Stack<int[]> stack = new Stack<>();
    /** initialize your data structure here. */
    public OneFiftyFive_MinStack() {

    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x,x});
            return;
        }

        stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
