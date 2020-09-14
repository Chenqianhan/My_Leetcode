package Interview;

public class OneThirtySix_SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int n:nums){
            //a xor b xor a = (a xor a) xor b = b;
            a^=n;
        }
        return a;
    }
}
