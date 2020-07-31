package DPandGreedy;

public class SixtyThree_UniqyePathsSecond {
    /**
     * Runtime: 1 ms, faster than 40.34% of Java online submissions for Unique Paths II.
     * Memory Usage: 39.8 MB, less than 5.18% of Java online submissions for Unique Paths II.
     * It can be further optimized, only change the way we manipulate dp[][], where basic idea is same.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Corner cases: [[1]]->0 and [[0]]->1
        //This is a trap, the way the picture shows is totally different to what it actually is.
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i<n-1) dp[i+1][j]+=dp[i][j];
                if(j<m-1) dp[i][j+1]+=dp[i][j];
            }
        }

        return dp[n-1][m-1];
        /*
        int[][] dp = new int[n][m];
        dp[n-1][0]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i>0) dp[i-1][j]+=dp[i][j];
                if(j<m-1) dp[i][j+1]+=dp[i][j];
            }
        }

        return dp[0][m-1];
        */
    }
}
