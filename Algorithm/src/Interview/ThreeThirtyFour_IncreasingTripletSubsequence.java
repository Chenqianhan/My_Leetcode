package Interview;

public class ThreeThirtyFour_IncreasingTripletSubsequence {
    //占坑法
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        for(int n: nums){
            if(n<=firstNum){
                firstNum = n;
            }else if(n<=secondNum){
                secondNum = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
