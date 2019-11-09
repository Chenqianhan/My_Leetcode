package solutions;
//Cannot not use multiplication, division and mod operation.
/*
Related knowledge:
Complement code -> 8 bit range is [-128, 127].
<< is bitwise operation to left. >> is to right
 */


public class TwentyNine_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //Because of the binary complement operation, the absolute value of MIN_VALUE is greater than the absolute value of MAX_VALUE. That's what causes overflow in division
        //因为二进制的补码运算, 所以最小值的绝对值比最大值的绝对值要大1. 除法里只有这点造成溢出
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        int a=Math.abs(dividend);
        int b=Math.abs(divisor);
        int result=0;
        //MUST USE greater or equal to, otherwise divisible cannot be considered
        //Note that the reason why not minus divisor one by one is that 10-3X2-3 is faster than 10-3-3-3. Multiplication and division is not allowed but bitwise operation is allowed
        //while(a-b>0){
        while(a-b>=0){
            int exponent=0;
            //<< is bitwise operation to left. (b<<1<<exponent) means b*2^(1+exponent).
            while(a-(b<<1<<exponent)>=0){
                exponent++;
            }
            result+=1<<exponent;
            a-=b<<exponent;
        }
        //It's a concise statement to cope with problem of whether result is positive or negative.
        return (dividend>=0) == (divisor>=0) ? result:-result;
    }
}
