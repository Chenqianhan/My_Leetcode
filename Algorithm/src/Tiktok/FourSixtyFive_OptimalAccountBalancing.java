package Tiktok;

import java.util.HashMap;

public class FourSixtyFive_OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> debt = new HashMap<>();
        for(int[] i:transactions){
            debt.put(i[0], debt.getOrDefault(i[0], 0) + i[2]);
            debt.put(i[1], debt.getOrDefault(i[1], 0) - i[2]);
        }

        int[] d = new int[debt.size()];
        int idx = 0;
        for(int i:debt.values()){
            d[idx++] = i;
        }

        return dfs(0, d);
    }

    public int dfs(int start, int[] debt){
        while(start < debt.length && debt[start] == 0) start++;
        if(start == debt.length) return 0;

        int cnt = Integer.MAX_VALUE;
        for(int i = start+1; i<debt.length; i++){
            if(debt[start]*debt[i]<0){
                debt[i] += debt[start];
                cnt = Math.min(cnt, dfs(start+1, debt) + 1);
                debt[i] -= debt[start];
            }
        }

        return cnt;
    }
}
