package Graph;

import java.util.Stack;

public class SevenEightyFive_IsGraphBipartite {
    //Graph Coloring, but I still don't understand the problem.
    //Got it, graph[i] is a list of indexes j for which the edge between nodes i and j exists. i.e. In index of i, for each j of graph[i], there is an edge between i and j.
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        //A little bit improvement avoiding Arrays.fill.
        //Arrays.fill(color,-1);

        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                //if(color[i]==-1){
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i]=1;
                //color[i]=0;

                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    for(int nxt:graph[cur]){
                        if(color[nxt]==0){
                            //if(color[nxt]==-1){
                            stack.push(nxt);
                            //^ is xor bit operation, if same->0, diff->1;
                            //color[nxt]=color[cur]^1;
                            color[nxt]=-color[cur];
                        }else if(color[nxt]==color[cur]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
