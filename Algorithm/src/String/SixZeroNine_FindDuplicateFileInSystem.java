package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SixZeroNine_FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String path:paths){
            String[] strs = path.split(" ");
            for(int i=1;i<strs.length;i++){
                String[] file = strs[i].split("\\(");
                String content = file[1].substring(0,file[1].length()-1);
                if(!map.containsKey(content)){
                    List<String> list = new ArrayList<>();
                    list.add(strs[0]+"/"+file[0]);
                    map.put(content, list);
                }else{
                    List<String> list = map.get(content);
                    list.add(strs[0]+"/"+file[0]);
                }
            }
        }

        List<List<String>> res = new LinkedList<>();
        for(String content:map.keySet()){
            if(map.get(content).size()>1)
                res.add(map.get(content));
        }

        return res;
    }
}
