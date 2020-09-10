package Array;

import java.util.ArrayList;
import java.util.List;

public class FourFortyTwo_FindAllDuplicateInArray {
    //Cuz elements appear at most twice and 0<a[i]<=n. We can use the idx to identify repeated numbers.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            int idx = Math.abs(num)-1;
            nums[idx] *= -1;
            if(nums[idx]>0) list.add(idx+1);
        }
        return list;
    }
    /*
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            if(set.contains(i)) list.add(i);
            else set.add(i);
        }

        return list;
    }
    */

    /*
    //O(1) space wait cause TLE.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(binarySearch(nums, 0, nums.length-1, i))
                if(!list.contains(nums[i]))
                    list.add(nums[i]);
        }
        return list;
    }

    public boolean binarySearch(int[] nums, int l, int r, int benchmark){
        if(l>r) return false;
        int mid = r - (r - l)/2;
        if(mid == benchmark || nums[mid] != nums[benchmark]){
            return binarySearch(nums, l, mid-1, benchmark) | binarySearch(nums, mid+1, r, benchmark);
        }else{
            return true;
        }
    }
    */
}
