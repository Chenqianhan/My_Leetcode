package Array;

public class OneFiftyThree_findMinimumInRotatedSortedArray {
    //Binary
    public int findMin(int[] nums){
        if (nums==null || nums.length==0) { return Integer.MIN_VALUE; }
        int left = 0, right = nums.length-1;
        while(left<right-1){
            int mid = (left+right)/2;
            //It has to be (nums[mid]>nums[right]), or it fails for completely ascending array.
            if(nums[mid]>nums[right]){
                left = mid;
            }else{
                right = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
        //It can be replaced by this.
        //return Math.min(nums[left], nums[right]);
    }

    /*
    //Brute force
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
