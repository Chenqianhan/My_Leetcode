package DPandGreedy;

public class Ten_RegularExpressionMatching {
    //It's hard to figure out it.
    public boolean isMatch(String s, String p) {
        //The indice of dp does not mean the indice in s and p, but means the amount of character.
        //The main difficulty is *.
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        //If the first one is *. It's false.
        if(p.length()>0 && p.charAt(0)=='*') return false;
        //dp[0][0] refers to empty of both.
        dp[0][0]=true;

        //The first scenario is that p is like the format that a*b*c* when s.length()=0.
        for(int a=1;a<=p.length();a++){
            if(p.charAt(a-1)=='*') dp[0][a]=dp[0][a-2];
        }
        //i is initialized from 1 is because the scenario s.length() is decided.
        for(int i=1;i<=s.length();i++){
            //j begins at 0 to make it false to every scenario that p.length() while s.length()>0.
            for(int j=0;j<=p.length();j++){
                if(j>0 && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')){
                    dp[i][j]=dp[i-1][j-1];
                }else if(j>0 && p.charAt(j-1)=='*'){
                    //scenario that substring a* is ignored.
                    dp[i][j]=dp[i][j-2];
                    //scenario that substring a* represents 1~n a.
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'){
                        dp[i][j]|=dp[i-1][j];
                    }
                }else dp[i][j]=false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
