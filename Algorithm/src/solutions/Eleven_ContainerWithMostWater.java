package solutions;
/*
该题主要难点在于思路，Brute Force穷举的做法的时间复杂度是O(n^2)
而这方法是用两个指针，时间复杂度为O(n)，已知The volume of water is positively correlated with distance of two pointers and height of the lower pointer.
Therefore, each comparison of max areas is calculated in each movement which is happened on the lower one.
Because there are two positively correlated factors. At first the two pointers are in the two ends which is the longest distance.
Then we narrow the distance to find a higher height. In this algorithm, in comparison with brute force, many meaningless steps,
like minor distance and minor height are ignored.

总的来说，与穷举法比，该方法首先处于距离最大，再寻找最高的低点高度，节省的时间复杂度，也就是小距离加上小高度的计算，被忽略掉。
 */
public class Eleven_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea=0,l=0,r=height.length-1;
        while(l<r){
            maxArea=Math.max(maxArea, Math.min(height[l],height[r])*(r-l));
            if(height[l]>height[r]) r--;
            else l++;
        }
        return maxArea;
    }
}
