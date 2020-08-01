package DPandGreedy;

public class SevenThree_SetMatrixZeroes {
    //Please look at the latter solution.
    //Seemingly efficiently but didn't do better than latter one.
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0]==0) isCol=true;

            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0 )
                    matrix[i][j]=0;
            }
        }

        if(matrix[0][0]==0){
            for(int j = 0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }

        if(isCol){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        /*This kind of way is incorrect
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                int idx = 1;
                while(idx<matrix[0].length)
                    matrix[i][idx++]=0;
            }
        }

        for(int j = 0;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                int idx = 1;
                while(idx<matrix.length)
                    matrix[idx++][j]=0;
            }
        }
        */
    }

    /*
    //Best 1ms(97%), 40MB(81%), runtime:O(m*n), space:O(m+n)
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    cols[j] = true;
                    rows[i] = true;
                }
            }
        }
        for(int i = 0; i<matrix.length;i++){
            if(rows[i]){
                int idx = 0;
                while(idx<matrix[0].length)
                    matrix[i][idx++]=0;
            }
        }

        for(int i = 0; i<matrix[0].length;i++){
            if(cols[i]){
                int idx = 0;
                while(idx<matrix.length)
                    matrix[idx++][i]=0;
            }
        }
    }
    */
}
