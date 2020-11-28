package TreeAndBinarySearchTree;

public class ThirtyFour_FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int left = helper(nums, target);
        if(left >= nums.length || nums[left]!=target)
            return new int[]{-1,-1};

        return new int[]{left, helper(nums, target+1)-1};
    }

    public int helper(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
