package DPandGreedy;

public class OneTwentyThree_BestTimeToTradeStockThird {
    public int maxProfit(int[] prices) {
        //Bidirectional DP, it is not the best but I can learn something from it.
        if(prices.length<2) return 0;
        int min = prices[0], max = prices[prices.length-1];
        int[] forwardProfit = new int[prices.length];
        int[] backwardProfit = new int[prices.length+1];

        for(int i = 1;i<prices.length;i++){
            forwardProfit[i] = Math.max(forwardProfit[i-1],prices[i]-min);
            min = Math.min(min, prices[i]);

            int j = prices.length-i-1;
            backwardProfit[j] = Math.max(backwardProfit[j+1],max-prices[j]);
            max = Math.max(max, prices[j]);
        }

        int profit = 0;
        for(int i=0;i<prices.length;i++){
            //That's why backward[].len is prices.length+1.
            //It is possible the max profit is by one trade.
            profit = Math.max(profit, forwardProfit[i]+backwardProfit[i+1]);
        }
        return profit;
    }
}
