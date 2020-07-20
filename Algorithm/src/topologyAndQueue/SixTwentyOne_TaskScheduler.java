package topologyAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SixTwentyOne_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: tasks){
            //Using map with getOrDefault is useful for counting elements.
            map.put(c, map.getOrDefault(c,0)+1);
        }

        //(a,b) -> b-a means we need a maxHeap in which the max is the root.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a );
        //Not to add map but map.values(). Cuz map is 2D while heap is 1D
        maxHeap.addAll(map.values());

        //It is the output, one unit of time means one cpu cycle usually.
        int cycles = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!maxHeap.isEmpty()){
                    //Remove and get the root(max number) of the heap;
                    temp.add(maxHeap.remove());
                }
            }

            for(int i:temp){
                if(--i>0) maxHeap.add(i);
            }

            //temp.size()<=n+1.
            //n+1 is the size of each round. It is fixed even remaining elements are less than n+1.
            cycles+=maxHeap.isEmpty()?temp.size():n+1;
        }

        return cycles;
    }
}
