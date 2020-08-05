package topologyAndQueue;
//Union
public class SixEightyFour_RedundantConnection {
    //Implementing DFS is quite inefficient here. Using Union would be better.
    //Size is between 3 to 1000
    public int[] findRedundantConnection(int[][] edges) {
        //We don't have to set it as maximum. the number of edges is at most 2*length of edges.
        Union u = new Union(edges.length*2);
        //Union u = new Union(1001);
        for(int[] edge:edges){
            if(!u.union(edge[0],edge[1])) return edge;
        }
        throw new AssertionError(); //If there is no return, means input has no redundant connection;
    }

    class Union{
        int[] parent;
        int[] rank;

        public Union(int size){
            parent = new int[size];
            for(int i=0;i<size;i++) parent[i]=i;
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
            }else{ //xp!=yp and rank[xp]!=rank[yp]
                parent[yp] = xp;
                rank[xp]++;
            }

            return true;
        }
    }
}
