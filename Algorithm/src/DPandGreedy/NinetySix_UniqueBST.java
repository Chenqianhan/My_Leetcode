package DPandGreedy;

public class NinetySix_UniqueBST {
    //Catalan Numbers.
    //This solution can also be used in problem that how many kinds of BST can we make given a list of numbers.
    public int numTrees(int n) {
        if(n==0) return 0;

        int[] dp = new int[n+1];
        dp[0]=1;dp[1]=1;

        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }
}
