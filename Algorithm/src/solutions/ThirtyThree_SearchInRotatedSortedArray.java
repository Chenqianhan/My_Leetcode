//It's labeled medium, but the question is too easy to make me doubt my reading ability.
//While the others' answer seems complicated, my answer's runtime faster than 100% and space less than 16.5%. Maybe when comes to a great deal of data my answer will perform not that good as others'. But intelligible and easy to modify
package solutions;

public class ThirtyThree_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
}
