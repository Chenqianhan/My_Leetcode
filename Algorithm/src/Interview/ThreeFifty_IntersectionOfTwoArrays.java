package Interview;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeFifty_IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i:nums1)
            map.put(i,map.getOrDefault(i,0)+1);

        int k = 0;
        for(int j:nums2){
            int cnt = map.getOrDefault(j,0);
            if(cnt>0){
                nums1[k++] = j;
                map.put(j,cnt-1);
            }
        }
        //We don't have to use List, instead we can make use of current object.
        return Arrays.copyOfRange(nums1,0,k);
        /*
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
        */
    }
}
