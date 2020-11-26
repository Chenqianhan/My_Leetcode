package StackAndHeap;

import java.util.Stack;

public class ThirtyTwo_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, start = -1;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    start = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i - start);
                    }else{
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
