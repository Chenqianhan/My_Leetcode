package TwoPointerAndLinkedList;

public class TwoZeroNine_MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0,j=0,sum=0,len=Integer.MAX_VALUE;
        while(j<nums.length){
            if(sum<s){
                sum+=nums[j++];
            }

            while(sum>=s){
                len = Math.min(len,j-i);
                sum-=nums[i++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}
