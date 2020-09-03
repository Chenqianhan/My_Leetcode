package DFSandBFS;

import java.util.HashSet;
import java.util.Set;

public class SixNinetyFour_NumberOfDistinctIsland {
    public int numDistinctIslands(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        Set<Set<String>> set = new HashSet<>();
        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[0].length;y++){
                if(grid[x][y]==1){
                    Set<String> island = helper(grid, x, y, x, y, new HashSet<>());

                    //Will only contain coordinates of unique island.
                    if(island.size()>0) set.add(island);
                }
            }
        }
        return set.size();
    }

    public Set<String> helper(int[][] grid, int x, int y, int x0, int y0, Set<String> island){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
            grid[x][y]=0;
            String coordinate = (x-x0)+","+(y-y0);
            //Record the relative coordinate of each point of this island.
            island.add(coordinate);

            helper(grid,x-1,y,x0,y0,island);
            helper(grid,x,y-1,x0,y0,island);
            helper(grid,x+1,y,x0,y0,island);
            helper(grid,x,y+1,x0,y0,island);
        }
        return island;
    }
}
