package StackAndHeap;

public class EightFiftySix_ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        //If input is valid, using 1 variable to cnt is better than stack.
        int cnt = 0, bal = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                bal++;
            }else{
                bal--;
                if(S.charAt(i-1)=='(') cnt += 1 << bal;
            }
        }
        // '(()(()))' = 2*(1+(2*1)) = 2*1 + 2*2*1
        return cnt;
    }
}
