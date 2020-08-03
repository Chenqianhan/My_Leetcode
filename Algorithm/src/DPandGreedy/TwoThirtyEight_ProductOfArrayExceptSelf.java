package DPandGreedy;

public class TwoThirtyEight_ProductOfArrayExceptSelf {
    //Optimized DP.
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]*res[i-1];
        }

        int R = 1;
        for(int j=nums.length-1;j>=0;j--){
            res[j]=res[j]*R;
            R*=nums[j];
        }
        /*The same as above but less efficient
        for(int j=nums.length-2;j>=0;j--){
            res[j]*=nums[j+1]*R;
            R*=nums[j+1];
        }
        */

        return res;
    }
    /*
    //DP O(n)/O(n), 1ms(100%)/48.4MB(7%).
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i=1;i<nums.length;i++){
            left[i]=nums[i-1]*left[i-1];
        }

        right[nums.length-1] = 1;
        for(int j=nums.length-2;j>=0;j--){
            right[j]=nums[j+1]*right[j+1];
        }

        for(int k=0;k<left.length;k++){
            left[k]*=right[k];
        }

        return left;
    }
    */
}
