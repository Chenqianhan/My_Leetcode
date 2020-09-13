package Interview;

import java.util.Arrays;

public class TwoSeventeen_ContainsDuplicate {
    //O(nlogn),O(1). If there is an additional requirement that ban sort, the second solution can be an alternative,
    //but will encounter TLE for a large array.
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); //O(nlogn)
        //O(n)
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]) return true;
        }
        return false;
    }

    /*
    //This is the version I have seen in last interview but I failed.
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(binarySearch(nums,0,nums.length-1,i)) return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int l, int r, int target){
        if(l>r) return false;
        int mid = r - (r-l)/2;
        if(nums[mid]==nums[target] && mid!=target) return true;

        return binarySearch(nums,l,mid-1,target)||binarySearch(nums,mid+1,r,target);
    }
     */
}
