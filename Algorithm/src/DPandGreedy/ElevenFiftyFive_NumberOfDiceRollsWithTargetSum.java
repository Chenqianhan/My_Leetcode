package DPandGreedy;

import java.util.HashMap;

public class ElevenFiftyFive_NumberOfDiceRollsWithTargetSum {
    //An easy but not that efficient recursion way.
    //idea of DP, implementation in recursion and memorization.
    final int MOD = 1000000007;
    HashMap<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if(target<d || target>d*f) return 0;
        if(d == 1) return target<=f?1:0;

        String key = ""+d+target;
        //if d = 3, i.e now we have f numbers to plus the cnt of 3+2; Using map to reduce repeated calculations.
        if(!memo.containsKey(key)){
            int sum = 0;
            for(int i = f; i>0; i--){
                sum += numRollsToTarget(d-1,f,target-i);
                sum%=MOD;
            }
            memo.put(key, sum);
        }
        return memo.get(key);
    }

}
