package dataStructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class NineEightyOne_TimeBasedKeyValueStore {
    private HashMap<String, TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public NineEightyOne_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            TreeMap submap = map.get(key);
            submap.put(timestamp,value);
        }else{
            TreeMap submap = new TreeMap<>(Comparator.reverseOrder());
            submap.put(timestamp,value);
            map.put(key,submap);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> submap = map.get(key);
        for(int i:submap.keySet()){
            if(i<=timestamp){
                return submap.get(i);
            }
        }
        return "";
    }
}
