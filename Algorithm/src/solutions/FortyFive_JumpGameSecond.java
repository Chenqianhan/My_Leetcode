package solutions;

import java.util.Arrays;

public class FortyFive_JumpGameSecond {
    //Runtime 98%, Memory 100%. The reason why runtime isn't 100% is because I add a statement to avoid unaccessibility.
    public int GreedyJump(int[] nums) {
        if(nums==null || nums.length<1) return 0;
        if(nums.length==1) return 0;
        int step=0;
        int current=0;
        int next=0;
        while(true){
            if(nums[current]+current<nums.length-1){
                int max=0;
                for(int i=1;i<=nums[current];i++){
                    if(nums[current+i]+current+i>max){
                        max=nums[current+i]+current+i;
                        next=current+i;
                    }
                }
                //Although unaccessible senario is not involved, it still needs mentioning.
                if(current==next) return 0;
                current=next;
                step++;
            }else{
                step++;
                break;
            }
            //It's weird that putting those statements here makes runtime 2ms, while putting above is 1ms.
            //if(current==next) return 0;
            //current=next;
            //step++;
        }
        return step;
    }

    //Not performances well, but it's a simple way to figure out.
    public int DPjump(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        Arrays.fill(dp,len);
        dp[0]=0;
        for(int i=0;i<len;i++){
            for(int j=1;j<=nums[i] && j<len-i;j++){
                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[len-1];
    }
}
