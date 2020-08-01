package DPandGreedy;

import java.util.Arrays;

public class ThreeHundred_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //Hard to understand. Look at it later.
        int[] dp = new int[nums.length];
        int max = 0;
        for(int num : nums) {
            int index = Arrays.binarySearch(dp, 0, max, num);
            if(index < 0) index = Math.abs(index) - 1;
            dp[index] = num;
            if(index == max) ++max;
        }

        return max;
    }
    /*
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;

        int[] dp = new int[nums.length];
        //Arrays.fill(dp,1);
        int max = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max+1;
    }
    */
}
