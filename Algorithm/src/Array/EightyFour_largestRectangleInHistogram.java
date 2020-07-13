package Array;

public class EightyFour_largestRectangleInHistogram {
    /**
     *The idea, same as annotated code, is calculating boundaries for each number i, within which all numbers are larger or equal to i.
     *But the former one is far faster than the latter:
     *1. The calculation of boundaries is isolated from main loop.
     *2. Rather than expanding boundary step by step, it jumps to the boundary of last boundary.
     *3. It is important to note that the boundaries' index is 1 outer than itself, i.e. A{1,3,1} the boundary of A[1] is [0,2].
     *4. The reason for 3 is that in A{3,4,3,4}, boundary of A[2] is [0,4], if we assign boundaries' index as itself, then the boundary of A[2] is [1,3], then we fail to jump cuz the boundary of A[1] is [1]. Indeed we can add more operations to make it expandable in this situation but it is not necessary.
     */
    public int largestRectangleArea(int[] heights){
        if(heights.length<1) return 0;
        int[] leftBoundary = new int[heights.length];
        int[] rightBoundary = new int[heights.length];
        leftBoundary[0]=-1;
        rightBoundary[heights.length-1] = heights.length;

        for(int i=1;i<heights.length;i++){
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i]) p = leftBoundary[p];
            leftBoundary[i] = p;
        }

        for(int j=heights.length-2;j>=0;j--){
            int p = j+1;
            while(p<heights.length && heights[p]>=heights[j]) p = rightBoundary[p];
            rightBoundary[j] = p;
        }

        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max(max, heights[i]*(rightBoundary[i]-leftBoundary[i]-1));
        }

        return max;
    }
    /*
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max(max, spread(heights, i));
        }

        return max;
    }

    public int spread(int[] heights, int index){
        int i = index;
        int width = 1;
        while(i>0 && heights[index]<=heights[i-1]){
            i--;
            width++;
        }

        i = index;
        while(i<heights.length-1 && heights[index]<=heights[i+1]){
            i++;
            width++;
        }

        return heights[index]*width;
    }
    */
}
