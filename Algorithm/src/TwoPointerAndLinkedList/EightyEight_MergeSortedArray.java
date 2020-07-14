package TwoPointerAndLinkedList;

public class EightyEight_MergeSortedArray {
    //Mistake: Cuz elements of nums1 begin at 0, it is complicated to compare smaller first.
    //Then I found it will be easier to compare larger first. How stupid I was.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n>0)
            nums1[m+n-1]=(m==0 || nums2[n-1]>nums1[m-1])?nums2[--n]:nums1[--m];
    }
}
