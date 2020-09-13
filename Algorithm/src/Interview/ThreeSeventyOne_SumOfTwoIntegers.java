package Interview;

public class ThreeSeventyOne_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);
        //Make usre x>=y;
        if(x<y) return getSum(b,a);

        int sign = a>0?1:-1;

        if(a*b >= 0){
            while(y!=0){
                //XOR: different = 1, same = 0;
                //相同为1则用XOR为0.
                int answer = x^y;
                //AND, 相同为1, 并进一位.
                int carry = (x&y)<<1;
                x = answer;
                //用y记录进位, 直到没有进位
                y = carry;
            }
        }else{
            //Substraction. Cuz x and y have different sign. And x>y
            while(y!=0){
                int answer = x^y;
                int borrow = ((~x)&y)<<1;
                x = answer;
                y = borrow;
            }
        }
        return x*sign;
    }
}
