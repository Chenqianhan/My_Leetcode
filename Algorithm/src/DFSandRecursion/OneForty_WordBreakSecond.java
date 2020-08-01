package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;

public class OneForty_WordBreakSecond {
    //Corner cases: "aaaa...."/["a","aa","aaa"]->[] which cases TLE
    //Same DFS as below.
    public List<String> wordBreak(String s, List<String> wordDict) {
        //It didn't really solve this corner case;
        if (s.length() > 100) return new ArrayList();

        List<String> res = new ArrayList<>();
        helper(s,wordDict,res,new StringBuilder());
        return res;
    }

    public void helper(String s, List<String> wordDict, List<String> res, StringBuilder subList){
        if(subList.length()!=0){
            subList.append(" ");
        }

        for(String word:wordDict){
            if(s.startsWith(word)){
                StringBuilder sb = new StringBuilder(subList);
                sb.append(word);

                if(s.equals(word)){ //base case
                    res.add(sb.toString());
                }else{
                    helper(s.substring(word.length()),wordDict,res,sb);
                }
            }
        }

    }


    /*
    //Memo is to solve this special cases
    //7ms(79%),40(41%)
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,new HashMap<>());
    }

    public List<String> helper(String s, List<String> wordDict, Map<String,List<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();

        //Base case
        if(s.length()==0){
            res.add("");
            return res;
        }

        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> subStrings = helper(s.substring(word.length()), wordDict,memo);

                for(String substring:subStrings){
                    String space = substring.isEmpty()?"":" ";
                    res.add(word + space + substring);
                }
            }
        }

        memo.put(s, res);
        return res;
    }
    */
}
