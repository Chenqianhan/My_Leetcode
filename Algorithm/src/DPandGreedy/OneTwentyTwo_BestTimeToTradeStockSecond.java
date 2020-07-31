package DPandGreedy;

public class OneTwentyTwo_BestTimeToTradeStockSecond {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;

        int profit = 0;
        for(int i=1;i<prices.length;i++){
            profit+=(prices[i]>prices[i-1])?prices[i]-prices[i-1]:0;
        }
        return profit;
    }
}
