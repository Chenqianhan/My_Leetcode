package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ThreeEighty_RandomizedSet {
    Random rand = new Random();
    List<Integer> list = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public ThreeEighty_RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int lastNum = list.get(list.size()-1);
        int idx = map.get(val);

        list.set(idx, lastNum);
        map.put(lastNum,idx);
        map.remove(val);
        list.remove(list.size()-1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
