package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EightEightySix_PossibleBipartition {
    //Unlike 785, both 785 and 886 are undirected graph. But 785 is given adjacent list, while 886 is given set of edges.
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N<2 || dislikes.length==0) return true;
        ArrayList[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i]=new ArrayList<>();
        for(int[] dislike:dislikes){
            //To convert dislikes into adjacent list.
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        int[] color = new int[N+1];
        Arrays.fill(color,-1);
        //color[1]=0;
        for(int i=1;i<=N;i++){
            if(color[i]==-1){
                color[i]=0;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    for(Object o:graph[cur]){
                        int nxt = (int)o;
                        if(color[nxt]==-1){
                            color[nxt]=color[cur]^1;
                            stack.push(nxt);
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
