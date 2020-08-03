package DPandGreedy;

public class ThreeTwelve_BurstBalloons {
    //One primary idea of this problem is that what we do is to choose to keep which one. Then recursively find the remaining.
    //It can be regarded as DP in Top-down manner or Divide-and-Conquer. To be more specific, it is Divide-and-Conquer with memorization.
    public int maxCoins(int[] nums) {
        int n = nums.length + 2; //We need two ends initialized by 1.
        //Initialization
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0]=newNums[n-1]=1;

        //Cache results of dp. It can be regarded as dp[].
        int[][] memo = new int[n][n];

        return helper(memo, newNums, 0, n-1);
    }

    public int helper(int[][] memo, int[] nums, int l, int r){
        if(l+1==r) return 0; //End condition.

        //Avoid repeated operation;
        if(memo[l][r]>0) return memo[l][r];

        int res = 0;
        //l and r are indices of nums that used to multiple nums[i];
        for(int i = l+1;i<r;i++){
            res = Math.max(res, nums[l]*nums[i]*nums[r]
                    +helper(memo,nums,l,i)+helper(memo,nums,i,r));
        }
        memo[l][r]=res;
        return res;
    }
}
