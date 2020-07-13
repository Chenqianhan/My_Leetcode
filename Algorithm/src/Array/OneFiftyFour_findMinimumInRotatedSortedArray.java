package Array;

public class OneFiftyFour_findMinimumInRotatedSortedArray {
    //Binary solution of LC153 doesn't work on [3,3,1,3];
    public int findMin(int[] nums){
        if (nums==null || nums.length==0) { return Integer.MIN_VALUE; }
        int left = 0, right = nums.length-1;
        while(left<right-1){
            int mid = (left+right)/2;
            //It has to be (nums[mid]>nums[right]), or it fails for completely ascending array.
            if(nums[mid]>nums[right]){
                left = mid;
            }else if(nums[mid]>nums[left]){
                right = mid;
            }else{
                right--; //Simply adding this block solving input like[3,3,1,3] that left,mid and right are all the same.
            }
        }

        return Math.min(nums[left], nums[right]);
    }


    /*
    //The solution of LC153 still works but not performs that good.
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) { return Integer.MIN_VALUE; }

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return nums[i+1];
            }
        }
        //Cope with situations that nums.length==1 or nums is completely in ascending order.
        return nums[0];
    }
    */
}
