package Array;

public class TwoEightyThree_MoveZeros {
    /*
    //Bubble
    public void moveZeroes(int[] nums) {
        //I recorded last index of zero but it fails. Then turning to record last index of non-zero seems feasible.
        int lastNonzero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[lastNonzero++]=nums[i];
        }

        for(int i=lastNonzero;i<nums.length;i++)
            nums[i]=0;
    }
    */
    //moveZeroes pro~~, but performs the same as above.
    public void moveZeroes(int[] nums) {
        int lastNonzero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(lastNonzero!=i){
                    nums[lastNonzero] = nums[i];
                    nums[i]=0;
                }
                lastNonzero++;
            }
        }
    }
}
