package solutions;
//Double 100% performance
/*i.e.
1 2 3                                             * * 3
4 5 6 The positions we need to recur is the stars * 5 6
7 8 9                                             7 8 9
 */
public class FortyEight_rotateImage {
    public void rotate(int[][] matrix) {
        if(matrix.length<=1) return;

        int len=matrix.length-1;
        int iLen=(matrix.length%2==0)?matrix.length/2:matrix.length/2+1;
        int jLen=matrix.length/2;

        for(int i=0;i<iLen;i++){
            for(int j=0;j<jLen;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-j][i];
                matrix[len-j][i]=matrix[len-i][len-j];
                matrix[len-i][len-j]=matrix[j][len-i];
                matrix[j][len-i]=temp;
            }
        }
    }
}
