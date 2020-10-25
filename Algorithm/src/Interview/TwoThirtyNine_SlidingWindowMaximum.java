package Interview;

import java.util.LinkedList;

public class TwoThirtyNine_SlidingWindowMaximum {
    //For frequent Add-Delete, LinkedList is better than Stack and Deque.
    LinkedList<Integer> list = new LinkedList<>();
    int[] nums;

    public void cleanList(int i, int k){
        //Cleaning index out of range.
        if(!list.isEmpty() && list.getFirst()==i-k)
            list.removeFirst();
        //Cleaning from behind. Not first, or those not peek number stack up from behind.
        while(!list.isEmpty() && nums[i]>nums[list.getLast()])
            list.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length*k==0) return new int[0];
        if(k==1) return nums;

        this.nums = nums;
        //Init
        for(int i=0;i<k;i++){
            cleanList(i,k);
            list.addLast(i);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = nums[list.getFirst()];

        for(int i=k;i<nums.length;i++){
            cleanList(i,k);
            list.addLast(i);
            res[i-k+1] = nums[list.getFirst()];
        }

        return res;
    }
}
