package StackAndHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//One problem of 496 is the problem description is so confusing.
//nums1 is the subset of nums2, and elements are unique.
//Wrong interpretation:
//i.e.[4,1,2]&[1,3,4,2]. I thought 1's next greater is 3 cuz index of 1 in nums1 is 1 and the nums[1] is 3 which is greater.
//And 4 is nums1[0], there is no greater number in nums2[0->4];

//Actually:
//the nums[0]=4 is corresponding to nums2[3]=4, and there is no greater number for 4 in nums2.
//So I misunderstand the meaning of corresponding.
public class FourNinetySix_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int value : nums2) {
            while (!stack.isEmpty() && value > stack.peek()) {
                nextGreater.put(stack.pop(), value);
            }
            stack.push(value);
        }
        /*
        //Thie process can be replaced by getOrDefault.
        while(!stack.isEmpty()){
            nextGreater.put(stack.pop(),-1);
        }
        */
        //int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nextGreater.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
