package DFSandRecursion;

public class FiftyTwo_NQueensSecond {
    public int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] diagonal_1 = new int[n*2-1];
        int[] diagonal_2 = new int[n*2-1];
        return helper(n,0,0,cols,diagonal_1,diagonal_2);
    }

    public int helper(int n, int row, int count, int[] cols, int[] diagonal_1, int[] diagonal_2){
        for(int i=0;i<n;i++){
            if(isAvailable(n,row,i,cols,diagonal_1,diagonal_2)){
                cols[i]=1;
                diagonal_1[row+i]=1;
                diagonal_2[row-i+n-1]=1;

                if(row+1==n) count++;
                else count = helper(n, row+1, count, cols, diagonal_1, diagonal_2);

                cols[i]=0;
                diagonal_1[row+i]=0;
                diagonal_2[row-i+n-1]=0;
            }
        }
        return count;
    }

    public boolean isAvailable(int n, int row, int col, int[] cols, int[] diagonal_1, int[] diagonal_2){
        int res = cols[col] + diagonal_1[row+col] + diagonal_2[row-col+n-1];
        return res==0;
    }
}
