package topologyAndQueue;

public class SixTwentyTwo_DesignCircularQueue {
    private int capacity, head, tail;
    private int[] queue;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public SixTwentyTwo_DesignCircularQueue(int k) {
        queue = new int[k+1];
        capacity = k+1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;

        queue[tail] = value;
        tail = (tail+1)%capacity;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;

        head = (head+1)%capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty()?-1:queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()?-1:queue[(tail-1+capacity)%capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head==(tail+1)%capacity;
    }
}
