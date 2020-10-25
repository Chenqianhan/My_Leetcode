package DPandGreedy;

public class FiveSixteen_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) return 0;

        char[] str = s.toCharArray();
        int[][] dp = new int[len][len];
        //Initialization
        for(int i=0;i<len;i++) dp[i][i] = 1;

        //It is kind of like bubble, an increasing window.
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(str[i]==str[j]){
                    //it fits both situations of odd and even len of palindrome.
                    dp[i][j] = dp[i-1][j+1] + 2;
                }else{
                    //
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
                }
            }
        }

        return dp[len-1][0];
    }
}
