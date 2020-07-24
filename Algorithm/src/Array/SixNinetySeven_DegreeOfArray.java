package Array;

import java.util.Collections;
import java.util.HashMap;

public class SixNinetySeven_DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> degree = new HashMap<>();
        HashMap<Integer, Property> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            //degree.put(num, degree.getOrDefault(num,0)+1);
            if(!map.containsKey(num)){
                Property p = new Property();
                p.head = i;
                p.tail = i;
                map.put(num, p);
                degree.put(num, 1);
            }else{
                Property p = map.get(num);
                p.tail = i;
                degree.put(num, degree.get(num)+1);
            }
        }
        int res = nums.length;
        int maxDegree = Collections.max(degree.values());
        for(int i:degree.keySet()){
            if(degree.get(i) == maxDegree)
                res = Math.min(res, map.get(i).tail-map.get(i).head+1);
        }

        return res;
    }

    class Property{
        int head;
        int tail;
    }
}
