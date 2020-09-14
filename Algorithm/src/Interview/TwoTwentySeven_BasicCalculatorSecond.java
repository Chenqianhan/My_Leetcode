package Interview;

public class TwoTwentySeven_BasicCalculatorSecond {
    //It is an optimal generic method.
    public int calculate(String s) {
        if(s.length()==0) return 0;
        //curNum is equal to each number between operators.
        //num is equal to each number between '+'or'-', it can be a single number or a product or quotient.
        int res = 0, curNum = 0, num = 0;
        char op = '+';
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c-'0';
            }else if(c!=' '){
                num = cal(num,curNum,op);
                //if op is '*'or'/', num will keep cumulated until next '+'or'-'
                if(c=='+' || c=='-'){
                    res+=num;
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
