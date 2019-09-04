package solutions;

import java.util.Arrays;

public class Sixteen_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //No need to use min which can be replaced by Math.abs(res-temp)
        //int min=Math.abs(nums[0])+Math.abs(nums[nums.length-1]);
        //我真蠢,把res设置成其中一个结果就行,被之前设min限制了思考
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int f=i+1, r=nums.length-1;
            while(f<r){
                int temp=nums[i]+nums[f]+nums[r];
                if(temp>target) r--;
                else f++;
                if(Math.abs(target-temp)<Math.abs(res-target)){
                    res=temp;
                }
            }
        }
        return res;
    }
}
