package Tiktok;

public class FourNintyThree_ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        return mergeSort(nums, 0, nums.length-1);
    }

    public int mergeSort(int[] nums, int start, int end){
        if(start >= end) return 0;

        int mid = start + (end - start)/2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        int p1 = start, p2 = mid+1;

        while(p1<=mid && p2<=end){
            if(nums[p1] > (long)nums[p2]*2){
                cnt += mid - p1 + 1;
                p2++;
            }else{
                p1++;
            }
        }

        merge(nums, start, end, mid);
        return cnt;
    }

    public void merge(int[] nums, int start, int end, int mid){
        int[] tmp = new int[end - start + 1];

        int p1 = start, p2 = mid+1, idx = 0;
        while(p1 <= mid && p2 <= end){
            if(nums[p1] > nums[p2]){
                tmp[idx++] = nums[p2++];
            }else{
                tmp[idx++] = nums[p1++];
            }
        }

        while(p1 <= mid){
            tmp[idx++] = nums[p1++];
        }

        while(p2 <= end){
            tmp[idx++] = nums[p2++];
        }

        if (idx >= 0) System.arraycopy(tmp, 0, nums, start, idx);
    }
}
