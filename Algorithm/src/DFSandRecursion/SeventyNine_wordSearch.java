package DFSandRecursion;

public class SeventyNine_wordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index==word.length()){
            return true;
        }

        if(i==-1 || i==board.length || j==-1 || j==board[0].length || board[i][j]!=word.charAt(index)){
            return false;
        }

        //Mark it to avoid backtrace.
        char temp = board[i][j];
        board[i][j] = ' ';

        boolean flag = dfs(board, word, i-1, j, index+1) ||
                dfs(board, word, i+1, j, index+1) ||
                dfs(board, word, i, j-1, index+1) ||
                dfs(board, word, i, j+1, index+1);

        board[i][j] = temp;
        return flag;
    }
}
