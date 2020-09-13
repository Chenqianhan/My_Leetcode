package Interview;

public class OneFiftyTwo_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int max = nums[0], min = nums[0], res = max;

        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            int tmp = Math.max(cur, Math.max(max*cur, min*cur));
            min = Math.min(cur, Math.min(max*cur,min*cur));
            max = tmp;

            res = Math.max(max, res);
        }

        return res;
    }
}
