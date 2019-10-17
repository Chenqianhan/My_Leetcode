package solutions;

public class Four_MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] arr=new int[nums1.length+nums2.length];
        double median;

        //if(nums1.length==0) arr=nums2;
        //if(nums2.length==0) arr=nums1;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]) arr[k++]=nums1[i++];
            else arr[k++]=nums2[j++];
        }
        while(i<nums1.length) arr[k++]=nums1[i++];
        while(j<nums2.length) arr[k++]=nums2[j++];

        if(arr.length%2==0) median=(double)(arr[arr.length/2]+arr[(arr.length/2)-1])/2;
        else median=arr[arr.length/2];

        return median;
    }

//Directly using arr.length improve the performance from 30% to 99% than defining a size which is assigned nums1.length+nums2.length. A phrase changes a lot
//The value from two int variables is also an int. Thus, if we need a double, we should add (double)
}
