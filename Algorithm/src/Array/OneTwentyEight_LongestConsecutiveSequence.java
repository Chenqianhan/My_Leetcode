package Array;

import java.util.HashSet;
import java.util.Set;

public class OneTwentyEight_LongestConsecutiveSequence{
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);

        int res = 0;
        for(int num:nums){
            //It means num is the smallest in a consecutive sequence
            if(!set.contains(num-1)){
                int cur = num, curLength = 1;
                while(set.contains(cur+1)){
                    cur++; curLength++;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }
}

