package solutions;
//It's a double 100% solution.

public class FortyTwo_trappingRainWater {
    public int trap(int[] height) {
        if(height.length<1) return 0;
        int left=0;
        int right=height.length-1;
        int maxLeft=0;
        int maxRight=0;
        int output=0;

        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=maxLeft){
                    maxLeft=height[left];
                    left++;
                }else{
                    output+=maxLeft-height[left];
                    left++;
                }
            }else{
                if(height[right]>=maxRight){
                    maxRight=height[right];
                    right--;
                }else{
                    output+=maxRight-height[right];
                    right--;
                }
            }
        }
        return output;

    }
}
