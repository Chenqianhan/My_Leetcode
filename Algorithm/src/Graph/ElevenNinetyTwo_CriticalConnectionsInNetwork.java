package Graph;

import java.util.ArrayList;
import java.util.List;
//This solution is important for graph.
public class ElevenNinetyTwo_CriticalConnectionsInNetwork {
    //Find bridge
    ArrayList<Integer>[] graph;
    int id = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        //Build graph.
        for(List<Integer> tmp:connections){
            int n1 = tmp.get(0);
            int n2 = tmp.get(1);
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,ids,low,visited,bridges);
        return bridges;
    }

    public void dfs(int at,int from,int[] ids,int[] low,
                    boolean[] visited,List<List<Integer>> bridges){
        visited[at] = true;
        ids[at]=low[at]=id++;

        for(int to:graph[at]){
            if(to==from) continue;
            if(!visited[to]){
                dfs(to,at,ids,low,visited,bridges);
                low[at] = Math.min(low[at],low[to]);
                if(ids[at]<low[to]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(at);
                    bridge.add(to);
                    bridges.add(bridge);
                }
            }else{
                low[at] = Math.min(low[at],low[to]);
            }
        }
    }
}
