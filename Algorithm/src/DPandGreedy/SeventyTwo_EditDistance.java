package DPandGreedy;

public class SeventyTwo_EditDistance {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        int row = c1.length, col = c2.length;
        int[][] dp = new int[row+1][col+1];
        //Initialize
        for(int i = 0;i<=row;i++) dp[i][0] = i;
        for(int j = 1;j<=col;j++) dp[0][j] = j;

        for(int i = 1;i<=row;i++){
            for(int j = 1;j<=col;j++){
                if(c1[i-1]==c2[j-1]) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1],dp[i-1][j]); //Insertion/Delete.
                    dp[i][j] = Math.min(dp[i][j], 1+dp[i-1][j-1]); //Replacement
                }
            }
        }

        return dp[row][col];
    }
}
