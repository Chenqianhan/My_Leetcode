package String;

public class SevenSeventyTwo_BasicCalculatorThird {
    //After finishing Basic Calculator 1 and 2, the combined solution of previous two can easily tackle this problem.
    int idx = 0;
    public int calculate(String s) {
        if(s.length()==0) return 0;

        int res = 0, curNum = 0, num = 0;
        char op = '+';
        while(idx<s.length()){
            char c = s.charAt(idx++);
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c - '0';
            }else if(c=='('){
                curNum = calculate(s);
            }else if(c==')'){
                break;
            }else if(c!=' '){
                num = cal(num, curNum, op);
                if(c=='+' || c=='-'){
                    res += num;
                    num = 0;
                }
                curNum = 0;
                op = c;
            }
        }

        return res+cal(num, curNum, op);
    }

    public int cal(int num, int curNum, char op){
        switch(op){
            case '+':
                return num+curNum;
            case '-':
                return num-curNum;
            case '*':
                return num*curNum;
            case '/':
                return num/curNum;
        }
        return 0;
    }
}
