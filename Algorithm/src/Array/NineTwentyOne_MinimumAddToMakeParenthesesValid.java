package Array;

public class NineTwentyOne_MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int res = 0, bal = 0;
        for(char c:S.toCharArray()){
            bal += c=='('?1:-1;
            if(bal==-1){
                res++;
                bal++;
            }
        }
        return bal+res;
    }
}
