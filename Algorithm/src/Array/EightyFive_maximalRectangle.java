package Array;

/**
 * The core idea is compressing the matrix, convert it into the problem of LC84. Then implement the solution of LC84.
 * build(): compress the 2D matrix into 1D height.
 */
public class EightyFive_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length<1 || matrix[0].length<1) return 0;

        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            build(height, matrix, i);
            max = Math.max(max, maxInLine(height));
        }

        return max;
    }

    public void build(int[] height, char[][] matrix, int index){
        for(int i=0;i<height.length;i++){
            if(matrix[index][i]=='1'){
                height[i]+=1;
            }else{
                height[i]=0; //The building collapses.
            }
        }
    }

    public int maxInLine(int[] nums){
        int[] leftBoundary = new int[nums.length];
        int[] rightBoundary = new int[nums.length];
        leftBoundary[0] = -1;
        rightBoundary[nums.length-1] = nums.length;

        for(int i=1;i<nums.length;i++){
            int p = i-1;
            while(p>=0 && nums[p]>=nums[i]) p = leftBoundary[p];
            leftBoundary[i] = p;
        }

        for(int j=nums.length-2;j>=0;j--){
            int p = j+1;
            while(p<nums.length && nums[p]>=nums[j]) p = rightBoundary[p];
            rightBoundary[j] = p;
        }

        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]*(rightBoundary[i] - leftBoundary[i] -1));
        }

        return max;
    }
}
