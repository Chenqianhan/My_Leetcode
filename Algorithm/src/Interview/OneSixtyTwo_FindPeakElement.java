package Interview;

public class OneSixtyTwo_FindPeakElement {
    public int findPeakElement(int[] nums) {
        //i.e. The sequence is in ascending order then in descending order because nums[-1]=nums[n]=无限小.
        //Thus we can use Binary Search in O(logn).
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (r+l)/2;
            //Why r - (r-l)/2 cause TLE
            if(nums[mid]>nums[mid+1])
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}
