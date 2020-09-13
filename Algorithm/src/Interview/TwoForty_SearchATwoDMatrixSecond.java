package Interview;

public class TwoForty_SearchATwoDMatrixSecond {
    //每一行或列的头部代表这一条的最小值, 我们从最大头开始往下算.
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0, row = matrix.length-1;
        //It is weird that change the order cause runtime error.
        //Oh I know, for matrix = [], there is no matrix[0].
        //while(col<matrix[0].length && row>=0){
        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col]>target){
                row--;
            }else if(matrix[row][col]<target){
                col++;
            }else{
                return true;
            }
        }

        return false;
    }
}
