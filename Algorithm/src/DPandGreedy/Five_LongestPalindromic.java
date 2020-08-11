package DPandGreedy;

public class Five_LongestPalindromic {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=centerCal(s,i,i);
            int len2=centerCal(s,i-1,i);
            int len=Math.max(len1,len2);
            if(len>end-start+1){
                start=i-len/2;
                end=i+(len-1)/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int centerCal(String s, int left, int right){
        int l=left, r=right;
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}
