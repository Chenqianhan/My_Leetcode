package topologyAndQueue;

//Deque means it is a double end queue on which we can operate from both side.
//In insertion, minus head before assigning value, plus tail after assigning value.
public class SixFortyOne_DesignCircularDeque {
    private int[] queue;
    private int capacity;
    private int head, tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public SixFortyOne_DesignCircularDeque(int k) {
        //The reason to plus 1 is to make a difference between empty and full;
        queue = new int[k+1];
        capacity = k+1;
        //We don't have to initialize integer variables Cuz their values are default 0;
        //head = 0;
        //tail = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;

        queue[head = (head - 1 + capacity)%capacity] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;

        queue[tail] = value;
        tail = (tail + 1)%capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;

        head = (head + 1)%capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;

        tail = (tail -1 + capacity)%capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()?-1:queue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty()?-1:queue[(tail -1 + capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head==tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail+1)%capacity==head;
    }
}
