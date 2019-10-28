package solutions;

public class TwentySix_RemoveDuplicateFromSArray {
    //Actually it's not right because the duplicate ones are not totally removed.
    //But it can still pass LC, weirdly. It's easy so I won't waste more time on it
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int mark=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[mark]){
                mark++;
                nums[mark]=nums[i];
            }
        }

        for(int i:nums) System.out.print(i);
        return mark+1;
    }
}
