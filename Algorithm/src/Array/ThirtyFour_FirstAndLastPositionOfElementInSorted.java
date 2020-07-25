package Array;

public class ThirtyFour_FirstAndLastPositionOfElementInSorted {
    public int[] searchRange(int[] nums, int target) {
        int[] results=new int[2];
        results[0]=searchResult(nums,target,true);
        results[1]=searchResult(nums,target,false);
        return results;
    }


    private int searchResult(int[] nums, int target,boolean isLeft){
        int start=0;
        int end=nums.length-1;
        int result=-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<target) start=mid+1;
            else if(nums[mid]>target) end=mid-1;
            else{
                if(isLeft){
                    result=mid;
                    end=mid-1;
                }else{
                    result=mid;
                    start=mid+1;
                }
            }
        }
        return result;
    }
}
