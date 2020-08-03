package DPandGreedy;
//With same solution for 70, it can be regarded as climbingStairs_Second.
//The method is not complicated. But it is a struggle to figure out how to solve this problem.
// Especially for '0'. '0' is ambiguous.
public class NinetyOne_DecodeWays {
    //Viewing the DP solution, we can see actually only previous two cnt are used at each time. Thus, we can optimize space complexity from O(n) to O(1);
    public int numDecodings(String s) {
        //int len = s.length();
        if(s.length()==0) return 0;

        int prev2 = 1;
        int prev1 = s.charAt(0)=='0'?0:1;

        for(int i = 2;i<=s.length();i++){
            int cur = 0;
            if(s.charAt(i-1)!='0'){
                cur+=prev1;
            }

            int lastTwo = Integer.parseInt(s.substring(i-2,i));
            if(lastTwo>9 && lastTwo<27){
                cur+=prev2;
            }

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
    /*
    //DP. Corner case: "01"->0, "10"->1, "909"->0; '0' has to be combined with previous, or it fails.
    public int numDecodings(String s) {
        if(s.length()<1)
            return 0;
        //i.e. dp[i] is equal to the number of decode ways of substring(0,i);
        int[] dp = new int[s.length()+1];
        //Initialization
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i = 2; i<dp.length;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }

            int lastTwo = Integer.parseInt(s.substring(i-2,i));
            //Cuz "07" can be parsed as 7.
            if(lastTwo>=10 && lastTwo<=26){
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()];
    }
    */
}
