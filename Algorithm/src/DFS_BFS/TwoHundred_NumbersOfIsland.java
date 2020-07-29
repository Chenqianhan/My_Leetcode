package DFS_BFS;

public class TwoHundred_NumbersOfIsland {
    //Optimized, 2ms(66%), 42MB(28%)
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    helper(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void helper(char[][] grid, int i, int j){
        if(i>grid.length-1 || j>grid[0].length-1 || i<0 || j<0 || grid[i][j]=='0')
            return;

        grid[i][j]='0';
        helper(grid, i+1, j);
        helper(grid, i, j+1);
        helper(grid,i-1,j);
        helper(grid,i,j-1);
    }
    /*
    //4ms(25.68%),44.5MB(5%)
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(helper(grid, i, j))
                    cnt++;
            }
        }
        return cnt;
    }

    public boolean helper(char[][] grid, int i, int j){
        if(grid[i][j]=='0' || grid[i][j]=='*')
            return false;

        grid[i][j]='*';
        if(i<grid.length-1) helper(grid, i+1, j);
        if(j<grid[0].length-1) helper(grid, i, j+1);
        if(i>0) helper(grid,i-1,j);
        if(j>0) helper(grid,i,j-1);
        return true;
    }
    */
}
