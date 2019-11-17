package solutions;
import java.util.*;
//Runtime 8ms faster than 97.18%; Memory 41.2MB less than 94.74%

public class FortyNine_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();

        List<List<String>> list=new ArrayList<>();
        Map<String, List<String>> map=new HashMap<>();

        for(String s:strs){
            String sorted=sort(s);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                List<String> temp=new ArrayList<>();
                temp.add(s);
                map.put(sorted,temp);
            }
        }

        /*
        for(List<String> l:map.values()){
            list.add(l);
        }
        */
        //The statement above can be replaced by:
        list.addAll(map.values());

        return list;
    }

    private String sort(String s){
        char[] c=s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
