package Graph;

import java.util.*;

public class SevenFourtyThree_NetworkDelayTime {
    //Minimum Spanning Tree. Single source shortest path.
    //Dijkstra's algorithm
    public int networkDelayTime(int[][] times, int N, int K) {
        //Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge:times){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b)->a[1]-b[1]);
        heap.offer(new int[]{K,0});

        Map<Integer,Integer> dist = new HashMap<>();

        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            if(dist.containsKey(cur[0])) continue;
            dist.put(cur[0],cur[1]);
            if(graph.containsKey(cur[0]))
                for(int[] edge:graph.get(cur[0])){
                    if(!dist.containsKey(edge[0]))
                        heap.offer(new int[]{edge[0],cur[1]+edge[1]});
                }
        }
        if(dist.size()!=N) return -1;
        int res = 0;
        for(int time:dist.values())
            res = Math.max(res,time);

        return res;
    }
    
}
