package StackAndHeap;

import java.util.PriorityQueue;

public class TwoFifteen_KthLargestNumber {
    //Indeed there are more efficiently quickSelect.
    //But it is far more complicate, it is not practical to be honest.
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        for(int i:nums)
            maxHeap.offer(i);

        while(k>1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.poll();
    }
}
