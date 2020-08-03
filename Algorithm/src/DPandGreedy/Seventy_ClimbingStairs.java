package DPandGreedy;
//Easy. No need to review.
public class Seventy_ClimbingStairs {
    //Most basic dynamic programming problem;
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        //Initialization
        dp[0] = 1; dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
