package Array;
//Easy. Unnecessary to review other than method: System.arraycopy();
public class SixtySix_PlusOne {
    public int[] plusOne(int[] digits) {
        //Corner case: [9];
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]++;
                break;
            }
        }
        if(digits[0]==0){
            int[] newDig = new int[digits.length+1];
            System.arraycopy(digits,0,newDig,1,digits.length);
            newDig[0]=1;
            return newDig;
        }
        return digits;
    }
}
