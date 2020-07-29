package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TwoTwentyFive_ImplementStackByQueue {
    //Basically Two ways:1. Two queues, push-O(n), pop-(1), Time-O(1), space-O(1)
    //2. One queue, push-O(n), pop-(1), Time-O(1), space-O(1)
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public TwoTwentyFive_ImplementStackByQueue() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size>1){
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
