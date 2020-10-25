package Interview;

public class TwoEightySeven_FindDuplicateNumber {
    //O(n)
    public int findDuplicate(int[] nums) {
        for(int num:nums){
            int cur = Math.abs(num);
            nums[cur]*=-1;
            if(nums[cur]>0) return cur;
        }
        return -1;
    }

    /*
    O(nlogn)
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return nums[i];
        }

        return -1;
    }
    */
}
