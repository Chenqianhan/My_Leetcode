package DFSandRecursion;

public class TwoSixtyThree_UglyNumber {
    //Simplified
    public boolean isUgly(int num) {
        if(num==0)
            return false;
        if(num == 2 || num == 3 || num == 5 || num == 1)
            return true;

        if(num%2==0){
            return isUgly(num/2);
        }else if(num%3==0){
            return isUgly(num/3);
        }else if(num%5==0){
            return isUgly(num/5);
        }

        return false;
    }
    /*
    public boolean isUgly(int num) {
        if(num==0)
            return false;
        return division(num);
    }

    public boolean division(int dividend){
        if(dividend == 2 || dividend == 3 || dividend == 5 || dividend == 1)
            return true;

        if(dividend%2==0){
            return division(dividend/2);
        }else if(dividend%3==0){
            return division(dividend/3);
        }else if(dividend%5==0){
            return division(dividend/5);
        }else{
            return false;
        }
    }
    */
}
