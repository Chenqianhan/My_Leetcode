package TwoPointerAndLinkedList;

public class SeventyFive_SortColor {
    // 1-pass/Two-pointer
    public void sortColors(int[] nums) {
        if(nums.length<2) return;

        int left = 0, right = nums.length-1;
        //It has to be i<=right, or it cannot solve [2,0,1];
        for(int i=0;i<=right;i++){
            if(nums[i]==0){
                nums[i]=nums[left];
                nums[left++]=0;
            }
            //i-- is to cope with situation that nums[right]=0;
            if(nums[i]==2){
                nums[i--]=nums[right];
                nums[right--]=2;
            }
        }
    }
}
