package Graph;

import java.util.*;

public class SevenEightSeven_CheapestFlightWithKStops {
    //It is a single pair Shortest Path problem, using Dijkstra revision works.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge:flights){
            List<int[]> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1],edge[2]});
            map.put(edge[0], list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1]-b[1]);
        queue.offer(new int[]{src,0,K});
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==dst){
                //res = Math.min(res, cur[1]);
                return cur[1];
                //break;
            }
            if(cur[2]<0) continue;
            for(int[] nxt:map.getOrDefault(cur[0], new ArrayList<>())){
                queue.offer(new int[]{nxt[0],cur[1]+nxt[1],cur[2]-1});
            }
        }
        return -1;
    }
    /*
    //It cause TLE when dealing with a great amount of edges.
    int res = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge:flights){
            List<int[]> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1],edge[2]});
            map.put(edge[0], list);
        }
        helper(map,src,dst,0,K);
        return res==Integer.MAX_VALUE?-1:res;
    }

    public void helper(Map<Integer, List<int[]>> map, int src, int dst, int total_W, int k){
        if(src==dst) res = Math.min(res, total_W);
        if(k<0) return;

        for(int[] nxt:map.getOrDefault(src, new ArrayList<>())){
            helper(map, nxt[0], dst, total_W+nxt[1],k-1);
        }
    }
    */

    /*
    //Not working, simply using DP and DFS/BFS cause the shorest path is not limited by k.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //Seems Dijkstra. But there is a restriction k.
        //Maybe DP works, Cuz label is range from 0 to n-1.
        //Build graph;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge:flights){
            List<int[]> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1],edge[2]});
            map.put(edge[0], list);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        for(int i=0;i<=K;i++){
            int size = queue.size();
            for(int j=0;j<size;j++){
                int cur = queue.poll();
                for(int[] des:map.getOrDefault(cur, new ArrayList<>())){
                    dp[des[0]] = Math.min(dp[des[0]], dp[cur]+des[1]);
                    queue.offer(des[0]);
                }
            }
        }

        return dp[dst]==Integer.MAX_VALUE?-1:dp[dst];
    }
*/
}
