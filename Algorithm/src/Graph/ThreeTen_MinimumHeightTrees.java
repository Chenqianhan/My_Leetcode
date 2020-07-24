package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreeTen_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(edges.length==0){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        ArrayList[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            //We need variable size to queue.size(), Cuz in consequent process, the size() is changing.
            int size = queue.size();
            count+=size;
            for(int i=0;i<size;i++){
                int node = queue.poll();
                degree[node]--;
                if(count==n) res.add(node);

                for(Object o:graph[node]){
                    int adjNode = (int)o;
                    //If adjNode degree = 0, it is a leaf that already processed.
                    if(degree[adjNode]!=0){
                        degree[adjNode]--;
                        if(degree[adjNode]==1)
                            queue.offer(adjNode);
                    }

                }
            }
        }
        return res;
    }
}

