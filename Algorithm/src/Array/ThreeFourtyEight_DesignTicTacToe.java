package Array;

public class ThreeFourtyEight_DesignTicTacToe {
    //int N = 0;
    int[] cols;
    int[] rows;
    int diag1;
    int diag2;
    /** Initialize your data structure here. */
    public ThreeFourtyEight_DesignTicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        //diags = new int[2];
        //N = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int move = player==1?1:-1;

        rows[row]+=move;
        cols[col]+=move;

        if(col==row){
            diag1+=move;
        }
        if(col+row+1==rows.length){
            diag2+=move;
        }
        if(cols[col]*move==rows.length || rows[row]*move==rows.length
                || diag1*move==rows.length || diag2*move==rows.length) return player;

        return 0;
    }
}
