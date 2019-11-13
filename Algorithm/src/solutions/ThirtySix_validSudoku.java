package solutions;
//A efficient way to store an array of boolean that using bit
//Such as 1=000000001, 2=000000010, 3=000000100 to store boolean array[9]

//Runtime faster than 99.99%, space less than 97.10%
public class ThirtySix_validSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rows=new int[9];
        int[] cols=new int[9];
        int[] squares=new int[9];

        //board.length reflects the number of rows in an 2d-array, and board[0].length reflects columns.
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]=='.') continue;

                //when using int, whether it's short or long depends on compiler. So it cost less memory to use short directly.
                //Because the number 0 to 9 is 000 to 009 in ASCII, thus, we can directly use char to calculate.
                //int value=(int)(1<<(board[row][col]-'1'));
                short value=(short)(1<<(board[row][col]-'1'));

                // & and | are bit operations. i.e. 000000001 & 000000010 = 000000000, 000000001 | 000000010 = 000000011
                //Maybe the true value of variables is not the same as the number they represent.
                //But it doesn't matter, we just need their binary number as a boolean array.
                //If value != rows[row], it's gonna be 0;
                if((value & rows[row])>0) return false;
                if((value & cols[col])>0) return false;
                if((value & squares[3*(row/3)+col/3])>0) return false;

                // "a|=b" = "a= a|b"
                rows[row] |= value;
                cols[col] |= value;
                squares[3*(row/3)+col/3] |= value;
            }
        }

        return true;
    }
}
