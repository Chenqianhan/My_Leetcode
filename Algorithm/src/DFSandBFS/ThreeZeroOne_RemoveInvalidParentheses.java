package DFSandBFS;

import java.util.ArrayList;
import java.util.List;

public class ThreeZeroOne_RemoveInvalidParentheses {
    //Process: Forward remove extra ')' -> Backward remove extre '(';
    List<String> res = new ArrayList<>();
    char[][] patterns = {{'(',')'},{')','('}};
    public List<String> removeInvalidParentheses(String s) {
        /*It is weird that adding the corner case makes it fail at empty string.
        if(s.length()<=1)
            return res;
        */
        /*Even in this way. Unexpected cases:1.""->[""], 2."n"->["n"]
        if(s.length()<=1){
            res.add("");
            return res;
        }
        */
        dfs(patterns[0],s,0,0);
        return res;
    }

    private void dfs(char[] pattern, String s, int start, int lastRemove){
        int len = s.length(), cnt = 0;
        //This round is to remove the first encountered right bracket;
        for(int i=start;i<len;i++){
            //Validate the string.
            if(s.charAt(i)==pattern[0]) cnt++;
            if(s.charAt(i)==pattern[1]) cnt--;
            if(cnt<0){
                for(int j=lastRemove;j<=i;j++){
                    char c = s.charAt(j);
                    if(c==pattern[1] && (j==lastRemove || c != s.charAt(j-1))){
                        dfs(pattern, s.substring(0,j)+s.substring(j+1,len), i, j);
                    }
                }
                return;
            }
        }

        //If right bracket is clear, we reverse it to clean extra left bracket.
        s = new StringBuilder(s).reverse().toString();
        if(pattern==patterns[0])
            dfs(patterns[1], s, 0, 0);
        else{
            //if pattern==patterns[1], it means we have traversed it on both way.
            res.add(s);
        }
    }
}
