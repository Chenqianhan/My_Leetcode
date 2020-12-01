package Tiktok;

import java.util.TreeMap;

public class SevenTwentySix_NumberOfAtoms {
    TreeMap<String, Integer> map;
    public String countOfAtoms(String formula) {
        map = new TreeMap<>();
        helper(formula, formula.length()-1, 1);

        StringBuilder sb = new StringBuilder();
        for(String key:map.keySet()){
            int num = map.get(key);
            sb.append(key).append(num>1?String.valueOf(num):"");
        }

        return sb.toString();
    }

    public int helper(String formula, int idx, int multiplier){
        int pre = multiplier;
        while(idx >= 0){
            char c = formula.charAt(idx);
            if(c == ')'){
                idx = helper(formula, idx-1, pre);
                //multiplier /= 1;
                pre = multiplier;
                continue;
            }else if(c == '('){
                return idx-1;
            }

            int edge = idx + 1;
            if(Character.isDigit(c)){
                while(Character.isDigit(formula.charAt(idx))) idx--;
                pre = Integer.parseInt(formula.substring(idx+1, edge)) * multiplier;
            }else if(Character.isLetter(c)){
                while(Character.isLowerCase(formula.charAt(idx))) idx--;
                String cur = formula.substring(idx, edge);
                map.put(cur, map.getOrDefault(cur, 0) + pre);
                pre = multiplier;
                idx--;
            }
        }
        return idx;
    }
}
