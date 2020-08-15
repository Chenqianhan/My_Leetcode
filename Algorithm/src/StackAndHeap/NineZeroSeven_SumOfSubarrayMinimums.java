package StackAndHeap;

import java.util.Stack;
//Keys:
//1. The condition of leftward is > while rightward is >= to deal with same numbers.
//2. Using Stack like DP, which improves drastically improve performance.
public class NineZeroSeven_SumOfSubarrayMinimums {
    //Intuitively I think we can start from each element to find the range of subarry that this element is the minimum.
    //But I don't know how to count the numbers of subarray. Then I know it is left+1*right+1.
    //Corner case: Same number. The condition of leftward is different to rightward. This concept need to be remember.
    //28ms 76.4%, 44.9MB 96%
    public int sumSubarrayMins(int[] A) {
        Stack<int[]> stack = new Stack<>();
        int[] left = new int[A.length], right = new int[A.length];
        for(int i=0;i<A.length;i++){
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek()[0]>A[i]){
                cnt+=stack.pop()[1];
            }
            left[i]=cnt;
            stack.push(new int[]{A[i],cnt});
        }
        stack = new Stack<>();
        for(int i=A.length-1;i>=0;i--){
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek()[0]>=A[i]){
                cnt+=stack.pop()[1];
            }
            right[i]=cnt;
            stack.push(new int[]{A[i],cnt});
        }
        int sum = 0;
        int MOD = 1_000_000_007;
        for(int i=0;i<A.length;i++){
            sum = (sum+left[i]*right[i]*A[i])%MOD;
        }
        return sum;
    }
    /*
    //812ms 5% and 41.3MB 99%, it can be improved.
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int sum = 0;
        for(int i=0;i<A.length;i++){
            int left = i-1, right = i+1;
            while(left>=0 && A[left]>A[i]){
                left--;
            }

            while(right<A.length && A[right]>=A[i]){
                right++;
            }
            sum=(sum+(i-left)*(right-i)*A[i])%MOD;
        }
        return sum;
    }
    */
}
