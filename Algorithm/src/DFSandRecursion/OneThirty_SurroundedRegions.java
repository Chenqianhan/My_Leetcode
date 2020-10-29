package DFSandRecursion;

public class OneThirty_SurroundedRegions {
    //From border calling DFS to traverse O into *;
    //Then those Os left are surrounded.
    public void solve(char[][] board) {
        if(board.length<3 || board[0].length<3) return;

        for(int i = 0; i < board.length; i++){
            helper(board, i, 0);
            helper(board, i, board[0].length-1);
        }

        for(int j = 1; j < board[0].length-1; j++){
            helper(board, 0, j);
            helper(board, board.length-1, j);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void helper(char[][] board, int i, int j){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j] == 'O' ){
            board[i][j] = '*';
            helper(board, i+1, j);
            helper(board, i-1, j);
            helper(board, i, j-1);
            helper(board, i, j+1);
        }
    }
}
