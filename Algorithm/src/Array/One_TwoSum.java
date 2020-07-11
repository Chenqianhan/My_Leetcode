package Array;

import java.util.HashMap;

public class One_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            n=target-i;
            if(!map.containsKey(n)){
                map.put(i,count++);
            }else{
                int[] output=new int[2];
                output[0]=map.get(n);
                output[1]=count;
                return output;
            }
        }
        return new int[2];
    }
}
