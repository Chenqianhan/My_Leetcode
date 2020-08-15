package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class NineZeroOne_OnlineStockSpan {
    List<Integer> prices;
    List<Integer> dp;
    public NineZeroOne_OnlineStockSpan() {
        prices=new ArrayList<>();
        dp = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1, i=prices.size()-1;
        while(i>-1){
            if(price>=prices.get(i)){
                span+=dp.get(i);
                i-=dp.get(i);
            }else break;
        }
        prices.add(price);
        dp.add(span);
        return span;
    }
}
