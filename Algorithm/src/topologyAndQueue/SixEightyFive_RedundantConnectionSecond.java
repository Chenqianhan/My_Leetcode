package topologyAndQueue;

import java.util.Arrays;

public class SixEightyFive_RedundantConnectionSecond {
    //Using Union like 684 is find, only if we make some changes.
    //Union is used to find loop. As a directed graph, we can see when there is a loop, the one we should remove is the one which indegree is larger than 1.
    //There are two situations, 1. root is inside the loop. 2. root is outside the root.
    //For 1, we can only delete the last edge. In this case all indegrees are 1.
    //For 2, we cannot simly implement solution of 684, cuz the root may not in the cycle. Thus, we need to look at the indegree.
    public int[] findRedundantDirectedConnection(int[][] edges) {
        //Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
        Union u = new Union(edges.length+1);
        int[] indegree = new int[edges.length+1];
        int cyclePoint = -1;
        for(int[] edge:edges){
            indegree[edge[1]]++;
            if(indegree[edge[1]]==2){
                cyclePoint = edge[1];
                break;
            }
        }

        //Which means it is situation 1.
        if(cyclePoint==-1) return findCycle(edges, null);
        //Then dealing with situation 2.
        //We have to move from last one, Cuz latter one need to be remove.
        //[[1,2],[1,3],[2,3]] will output [1,3] but actually [2,3];
        for(int i = edges.length-1;i>=0;i--){
            if(cyclePoint==edges[i][1]){
                if(findCycle(edges, edges[i])==null)
                    return edges[i];
            }
        }
        throw new AssertionError();
    }

    public int[] findCycle(int[][] edges, int[] skipEdge){
        Union dsu = new Union(edges.length+1);
        for(int[] edge:edges){
            if(Arrays.equals(edge, skipEdge)) continue; //Skip.
            if(!dsu.union(edge[0],edge[1])) return edge;
        }
        return null; //Means there is no loop at all;
    }

    class Union{
        int[] parent;
        int[] rank;
        public Union(int size){
            parent = new int[size];
            for(int i = 0;i<size;i++) parent[i] = i;
            rank = new int[size];
        }

        public int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);

            return parent[x];
        }

        public boolean union(int x, int y){
            int xp = find(x), yp = find(y);
            if(xp==yp){
                return false;
            }else if(rank[xp]<rank[yp]){
                parent[xp] = yp;
            }else if(rank[xp]>rank[yp]){
                parent[yp] = xp;
            }else{
                parent[yp] = xp;
                rank[xp]++;
            }

            return true;
        }
    }
}
