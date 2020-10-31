package DPandGreedy;

import java.util.ArrayList;
import java.util.List;

public class OneThirtyOne_PalindromePartitioning {
    //Compromise space to increase runtime performance;
    //If we traverse all substring recursively, it takes O(n^2), and each substring takes O(n^2).
    //Cuz the worse case is that we need to check all possibility.
    //So in total O(n^4).
    //But we can implement dp by O(n^2), and traverse all possible substrings by O(n^2) which are verified from dp by O(1).
    //Thus we got O(n^2) by dp and dfs backtracking.
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //j is the start position of substring, and i is the end
        for(int i = 0; i < len; i++){
            for(int j = 0; j<= i; j++){
                if(s.charAt(i)==s.charAt(j) && (i - j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }

        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, 0, dp);

        return res;
    }

    public void helper(List<List<String>> res, List<String> list, String s, int pos, boolean[][] dp){
        if(pos == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = pos; i<s.length(); i++){
            if(dp[pos][i]){
                list.add(s.substring(pos, i+1));
                helper(res, list, s, i+1, dp);
                list.remove(list.size()-1);
            }
        }
    }
}
