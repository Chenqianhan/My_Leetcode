package Array;

public class ThirtyOne_nextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length<2)
            return;
        int i = nums.length-2;
        //Find the first number which breaks descending order.
        while(i>=0 && nums[i]>=nums[i+1]) i--;

        if(i>=0){           //if not entirely descending.
            int j = nums.length-1;
            while(nums[i]>=nums[j]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i+1, nums.length-1);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i++, j--);
        }
    }
}
