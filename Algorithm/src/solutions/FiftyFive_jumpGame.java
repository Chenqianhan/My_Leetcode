package solutions;
//In this case, it's unwise to use DP.
public class FiftyFive_jumpGame {
    public boolean canJump(int[] nums) {
        int margin=0;
        for(int i=0;i<nums.length;i++){
            if(margin<i) return false;

            if(nums[i]!=0){
                margin=Math.max(margin, nums[i]+i);
            }
        }
        return true;
    }
}
