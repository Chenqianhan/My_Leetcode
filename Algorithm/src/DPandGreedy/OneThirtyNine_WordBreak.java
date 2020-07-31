package DPandGreedy;

import java.util.List;

public class OneThirtyNine_WordBreak {
    //DP 13ms, 44.6MB. Seemingly BFS is a better choice.
    public boolean wordBreak(String s, List<String> wordDict) {
        //It is necessary to look at problem description.
        //"If s can be segmented into a space-separated sequence of one or more dictionary words". One or more, not all dictionary words.
        int len = s.length();
        if(len==0){
            return false;
        }

        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1;i<=len;i++){
            for(int j = 0; j<i; j++){
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    /*I cannot figure out the true condition for DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length()+1; //we use len = s.length()+1 because of substring();
        boolean flag = false;
        for(int i = 1;i<len;i++){
            if(wordDict.contains(s.substring(0,i)))
                flag|=helper(s,wordDict,i,len);
        }
        return flag;
    }

    public boolean helper(String s, List<String> wordDict, int i, int len){
        boolean flag = false;
        for(int j = i+1;j<len;j++){
            if(wordDict.contains(s.substring(i,j)))
               flag|=helper(s,wordDict,j,len);
        }
        return flag;
    }
    */
}
