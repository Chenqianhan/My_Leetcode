package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Fifteen_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> set=new LinkedList<>();
        for(int i=0;i<nums.length-2;i++) {
            //Avoid duplicate first number.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int f = i + 1, r = nums.length - 1, sum = -nums[i];
                while (f < r) {
                    if (nums[f] + nums[r] == sum) {
                        set.add(Arrays.asList(nums[i], nums[f], nums[r]));
                        while (f < r && nums[f] == nums[f + 1]) f++;
                        while (f < r && nums[r] == nums[r - 1]) r--;
                        f++;
                        r--;
                    } else if (nums[f] + nums[r] < sum) f++;
                    else r--;
                }
            }
        }

        return set;
    }
}
