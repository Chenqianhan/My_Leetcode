package Graph;

public class FiveFourtySeven_FriendCircle {
    //DFS
    boolean[] visited;
    public int findCircleNum(int[][] M) {
        visited = new boolean[M.length];
        int cnt=0;
        for(int i=0;i<M.length;i++){
            if(!visited[i]){
                dfs(M, i);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int[][] M, int x){
        for(int i = 0;i<M.length;i++){
            if(M[x][i]==1 && !visited[i]){
                visited[i]=true;
                dfs(M,i);
            }
        }
    }

    /*
    //Union, 1 ms, 40.3 MB, 84%and33%
    public int findCircleNum(int[][] M) {
        Union dsu = new Union(M.length);
        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M[0].length;j++){
                if(M[i][j]==1)
                    dsu.union(i,j);
            }
        }
        int cnt=0;
        for(int p:dsu.parent){
            if(p==-1) cnt++;
        }

        return cnt;
    }

    class Union{
        int[] parent;

        public Union(int size){
            parent = new int[size];
            Arrays.fill(parent,-1);
        }

        public int find(int x){
            if(parent[x]==-1)
                return x;
            return find(parent[x]);
        }

        public void union(int i, int j){
            int ip = find(i), jp = find(j);
            if(ip!=jp){
                parent[jp]=ip;
            }
            //return true;
        }
    }
    */
}
