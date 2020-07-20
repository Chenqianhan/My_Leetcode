package topologyAndQueue;

public class ThreeTwentyNine_LongestIncreasingPathInMatrix {
    /**
     *DFS+DP memory.
     *Idea: memory longest path of each node to avoid unnecessary dfs traverse.
     *There is an alternative approach that is topological sort based and DP but performs worse.
     */
    private int[][] dp;
    private static final int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
    private int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;

        int max = 0;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(matrix,i,j));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j){
        if(dp[i][j]!=0)
            return dp[i][j];

        for(int[] dir: direction){
            int x = i+dir[0], y = j+dir[1];
            if(x>=0 && y>=0 && x<m && y<n && matrix[i][j]<matrix[x][y])
                dp[i][j] = Math.max(dp[i][j], dfs(matrix,x,y));
        }

        return ++dp[i][j];
    }
}
