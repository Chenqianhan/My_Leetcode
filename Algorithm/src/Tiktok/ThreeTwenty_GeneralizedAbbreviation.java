package Tiktok;

import java.util.ArrayList;
import java.util.List;

public class ThreeTwenty_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        //helper(0,word,new StringBuilder(),word.length(), false);
        //helper(list, word.toCharArray(), "", 0, 0);
        helper(list, word.toCharArray(), new StringBuilder(), 0, 0);

        return list;
    }

    public void helper(List<String> list, char[] word, StringBuilder sb, int idx, int cnt){
        int len = sb.length();
        if(idx == word.length){
            if(cnt > 0) sb.append(cnt);
            list.add(sb.toString());
        }else{
            helper(list, word, sb, idx+1, cnt+1);
            helper(list, word, sb.append(cnt>0?cnt:"").append(word[idx]), idx+1, 0);
        }
        sb.setLength(len); //Cut substring after len.
    }
    /*
    public void helper(List<String> list, char[] word, String cur, int idx, int count){
        if(idx == word.length){
            if(count > 0) cur += count;
            list.add(cur);
            return;
        }

        helper(list, word, cur, idx+1, count+1);
        helper(list, word, cur + (count>0?count:"") + word[idx], idx+1, 0);
    }
    */

    /*
    public void helper(int start, String word, StringBuilder sb, int len, boolean isLastDig){
        if(start == len){
            list.add(sb.toString());
            return;
        }
        sb.append(word.charAt(start));
        helper(start+1,word,sb, len, false);
        sb.deleteCharAt(sb.length()-1);

        if(!isLastDig){
            for(int i = start; i<len; i++){
                sb.append(String.valueOf(i-start+1));
                helper(i+1, word, sb, len, !isLastDig);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    */
}
