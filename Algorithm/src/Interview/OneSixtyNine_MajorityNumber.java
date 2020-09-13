package Interview;

import java.util.Arrays;

public class OneSixtyNine_MajorityNumber {
    public int majorityElement(int[] nums) {
        //Cuz majority is more than n/2 times.
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
