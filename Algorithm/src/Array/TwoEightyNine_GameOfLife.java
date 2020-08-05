package Array;

public class TwoEightyNine_GameOfLife {
    public void gameOfLife(int[][] board) {
        //int[][] neighbors = new int[board.length][board[0].length];
        int[] neighbors = {-1,0,1};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int neighborsNum = 0;
                for(int n=0;n<3;n++){
                    for(int m=0;m<3;m++){
                        //We have to avoid the element itself.
                        if(!(n==1 && m==1)){
                            int row = i + neighbors[n];
                            int col = j + neighbors[m];
                            //board[row][col] has to be absolute, or those element marked as -1 will not be counted
                            if((row>=0 && row<board.length)
                                    && (col>=0 && col<board[0].length)
                                    && Math.abs(board[row][col])==1)
                                neighborsNum++;
                        }
                    }
                }
                //Rule 1-3
                if(board[i][j]==1 && (neighborsNum<2 || neighborsNum>3)){
                    board[i][j]=-1; //Live to Dead
                    //Rule 4
                }else if(board[i][j]==0 && neighborsNum==3){
                    board[i][j]=2; //Dead to Live
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1) board[i][j]=0;
                else if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
}
