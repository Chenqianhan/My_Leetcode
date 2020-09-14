package Interview;

import java.util.Stack;

public class OneFifty_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            int first, second;
            switch(s){
                case "+":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first+second);
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first-second);
                    break;
                case "*":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first*second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first/second);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
