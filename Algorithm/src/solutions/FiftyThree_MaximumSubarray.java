package solutions;

public class FiftyThree_MaximumSubarray {
    //Double max variables
    /*
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=nums[0];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            temp=Math.max(nums[i],temp+nums[i]);
            max=Math.max(max,temp);
        }
        return max;
    }
    */

    //DP of higher performance. Double 100%, although similar to above.
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
            if(max<nums[i]) max=nums[i];
        }
        return max;
    }
}
