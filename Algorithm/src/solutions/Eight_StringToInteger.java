package solutions;
/*Note:
str=str.trim(); 消除字符串两端的空格
sign=(str.charAt(0)=='-')?-1:1; sign取值判定,若?前判定为正,则取:左侧值,反之右侧.
Character.isDigit(str.charAt(1)) 判定是否为数字

重点(判断溢出):
n=n*10+d; 可能产生overflow
所以判断是否n>(Integer.MAX_VALUE-d)/10, 若是则溢出.
若n是负数则可以n<(Integer.MAX_VALUE+d)/10.
因为该题我们的正负号是后加的,所以只用判断正的即可,最后再乘上sign
*/
public class Eight_StringToInteger {
    public int myAtoi(String str) {
        str=str.trim(); //trim()消除字符串两端的空格;
        if(str.isEmpty()) return 0;
        int sign=1;
        int index=0;
        if(str.charAt(0)=='-'||str.charAt(0)=='+'){
            sign=(str.charAt(0)=='-')?-1:1;
            if(str.length()<2||!Character.isDigit(str.charAt(1))){
                return 0;
            }
            index++;
        }
        int n=0;
        while(index<str.length()){
            if(Character.isDigit(str.charAt(index))){
                int d=str.charAt(index)-'0'; //因为是ASCII码;
                if(n>(Integer.MAX_VALUE-d)/10){
                    n=(sign==-1)?Integer.MIN_VALUE:Integer.MAX_VALUE;
                    return n;
                }
                n=n*10+d;
            }else{
                break;
            }
            index++;
        }
        return sign*n;
    }
}
