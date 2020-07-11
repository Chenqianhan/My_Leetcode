package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighteen_fourSum {
    /*
    Core idea:
    1. Cope with special cases: [0,0,0,0...]or[]
    2. Main function: In fourSum, lock the first element with condition nums[i]!=nums[i-1], to avoid locking identical elements in same position which causes duplicated list.
        In threeSum, lock the second element as well as the first, just basically implement 3sum which effectively avoid duplicate lists.

    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<4) return res;

        for(int i=0;i<nums.length;i++){
            //Avoid duplicated list.
            if(i>0 && nums[i]==nums[i-1])
                continue;
            //Bypass impossible elements.
            if(nums[i]+3*nums[nums.length-1]<target)
                continue;
            if(nums[i]*4>target)
                break;
            if(nums[i]*4==target){
                //Deal with input such as [0,0,0,0].
                if(i+3<nums.length && nums[i]==nums[i+3]){
                    res.add(Arrays.asList(nums[i],nums[i],nums[i],nums[i]));
                }
                break;
            }
            threeSum(nums, res, target-nums[i], i+1);
        }
        return res;
    }

    //4Sum cannot simply implement 3Sum Cuz I don't know how to do to avoid duplicated list while allowing identical elements.
    //The problem above is solved. It is not a problem of threeSum.
    public void threeSum(int[] nums, List<List<Integer>> res, int target, int index){
        //List<Integer> mark = new ArrayList<>(0);
        for(int i=index;i<nums.length-2;i++){
            //if(nums[i]!=mark){
            if(i==index || (i>index && nums[i]!=nums[i-1])){
                int j = i+1, k = nums.length-1, sum = target - nums[i];
                while(j<k){
                    if(nums[j]+nums[k]==sum){
                        List<Integer> temp = Arrays.asList(nums[index-1], nums[i], nums[j], nums[k]);
                        res.add(temp);
                        while(j<k && nums[j]==nums[j+1]) j++;
                        while(j<k && nums[k]==nums[k-1]) k--;
                        j++;
                        k--;
                    }else if(nums[j]+nums[k]<sum){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
    }
}
