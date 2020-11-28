package Tiktok;

public class FourTen_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 1;
        for(int i:nums){
            right += i;
            left = Math.max(left, i);
        }

        while(left < right){
            long mid = left + (right - left)/2;
            int num = 1;
            long cur = 0;
            for(int i:nums){
                cur += i;
                if(cur > mid){
                    num++;
                    cur = i;
                }
            }

            if(num > m){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return (int)left;
    }
}
