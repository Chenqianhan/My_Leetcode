package DPandGreedy;

public class SixtyTwo_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[n-1][0]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                if(i>0) dp[i-1][j]+=dp[i][j];
                if(j<m-1) dp[i][j+1]+=dp[i][j];
            }
        }
        return dp[0][m-1];
    }
}
