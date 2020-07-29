package dataStructure;

import java.util.Stack;

public class TwoThirtyTwo_ImplementQueueByStack {
    //Same as 225, chose push-O(n) or pop-O(n).
    //push-O(n),pop-O(1) is more convinent cuz peek();
    /** Initialize your data structure here. */
    Stack<Integer> s1;
    public TwoThirtyTwo_ImplementQueueByStack() {
        s1 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty())
            temp.push(s1.pop());
        temp.push(x);
        while(!temp.isEmpty())
            s1.push(temp.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
