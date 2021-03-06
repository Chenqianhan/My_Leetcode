package DPandGreedy;

public class ThreeTwentyTwo_CoinChange {
    //Do some optimation by reducing unnecessary operations or variables.
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for(int i=1;i<=amount;i++){
            dp[i] = dp.length;
            for(int coin:coins){
                if(coin<=i) dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==dp.length?-1:dp[amount];
    }
    /*
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;

        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i)
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    */
}
