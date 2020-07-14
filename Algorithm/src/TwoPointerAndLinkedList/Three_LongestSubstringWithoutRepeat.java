package TwoPointerAndLinkedList;

public class Three_LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        boolean[] used=new boolean[128];
        int n=s.length();
        int max=0;
        int left=0, right=0;
        while(right<n){
            if(!used[s.charAt(right)]){
                used[s.charAt(right)]=true;
                right++;
            }else{
                max=Math.max(max,right-left);
                //while(left<right){
                used[s.charAt(left)]=false;
                left++;
            }
        }
        max=Math.max(max,right-left);
        return max;
    }
}
