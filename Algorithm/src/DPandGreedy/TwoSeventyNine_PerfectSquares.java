package DPandGreedy;

import java.util.Arrays;

public class TwoSeventyNine_PerfectSquares {
    public int numSquares(int n) {
        int root = (int)Math.sqrt(n)+1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        int[] squareNum = new int[root];
        for(int i=1;i<root;i++){
            squareNum[i]=i*i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<root;j++){
                if(i<squareNum[j])
                    break;
                dp[i]=Math.min(dp[i], dp[i-squareNum[j]]+1);
            }
        }
        return dp[n];
    }
}
