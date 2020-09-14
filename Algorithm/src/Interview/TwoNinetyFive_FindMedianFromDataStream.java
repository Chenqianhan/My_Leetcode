package Interview;

import java.util.Collections;
import java.util.PriorityQueue;

public class TwoNinetyFive_FindMedianFromDataStream {
    //Two heap is the basic implementation.
    //There is a better method using BST with floating pointer of actual root in mid.
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    boolean even = true;
    /** initialize your data structure here. */
    public TwoNinetyFive_FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if(even){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even){
            return (large.peek()+small.peek())/2.0;
        }else{
            return large.peek();
        }
    }
}
