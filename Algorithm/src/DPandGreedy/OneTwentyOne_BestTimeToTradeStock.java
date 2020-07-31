package DPandGreedy;

public class OneTwentyOne_BestTimeToTradeStock {
    //Intuitively, define a min[] to record the accessible minPrice for each point.
    //The I found one min can work.
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        //Same as previous. Both result fluctuate.
        for(int i=1;i<prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
        }
        /* 99.42%,10.33%
        for(int p:prices){
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit,p-minPrice);
        }
        */
        return maxProfit;
    }
}
