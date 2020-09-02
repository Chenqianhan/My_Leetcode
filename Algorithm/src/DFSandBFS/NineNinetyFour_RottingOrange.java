package DFSandBFS;

public class NineNinetyFour_RottingOrange {
    //1ms 100%, 38.8 90%
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) cnt++;
            }
        }
        //res=-1 is because the last time when cnt!=lst, there is no more change but res still +1.
        int res = -1, lst = -1;
        while(cnt!=lst){
            lst=cnt;
            cnt=helper(grid,cnt);
            res++;
        }

        return cnt==0?res:-1;
    }

    public int helper(int[][] grid, int cnt){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    if(i>0 && grid[i-1][j]==1){
                        grid[i-1][j]=-1;
                    }
                    if(j>0 && grid[i][j-1]==1){
                        grid[i][j-1]=-1;
                    }
                    if(i<grid.length-1 && grid[i+1][j]==1){
                        grid[i+1][j]=-1;
                    }
                    if(j<grid[0].length-1 && grid[i][j+1]==1){
                        grid[i][j+1]=-1;
                    }
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                    grid[i][j]=2;
                    cnt--;
                }
            }
        }

        return cnt;
    }
}
