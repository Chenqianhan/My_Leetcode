package String;

public class TwoTwentyFour_BasicCalculator {
    //Once we see brackets/parentheses, there gotta be stack or recursion.
    int i = 0;
    public int calculate(String s) {
        if(s.length()==0) return 0;
        int res = 0, num = 0, sign = 1;
        while(i<s.length()){
            char c = s.charAt(i++);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c=='('){
                num = calculate(s);
            }else if(c==')'){
                break;
            }else if(c!=' '){
                res+=sign*num;
                num = 0;
                sign = c=='+'?1:-1;
            }
        }
        return res+sign*num;
    }
}
