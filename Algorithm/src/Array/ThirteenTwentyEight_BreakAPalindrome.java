package Array;

public class ThirteenTwentyEight_BreakAPalindrome {
    //Input type: len=0; len=1; All elements are "a" except the middle one; Else;
    //As a palindrome, checking the first half is enough, by which we can bypass middle element.
    //For those palindrome consists of "a" only. We can just replace it by "b" from tail.

    //Runtime: 0ms 100%. Space: 37.2~37.5 20%~88%
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len==1)
            return "";
        char[] strs = palindrome.toCharArray();

        int i = 0;
        while(i<len/2){
            if(!(strs[i]=='a')){
                strs[i]='a';
                break;
            }
            i++;
        }

        if(i==len/2)
            strs[len-1]='b';

        return new String(strs);
        /*
        String res = "";
        int len = palindrome.length();

        for(int i=0;i<len/2;i++){
            if(!(palindrome.charAt(i)=='a')){
                res = palindrome.substring(0,i)+"a"+palindrome.substring(i+1,len);
                break;
            }
        }

        if(res.length()==0 && len>1)
            res = palindrome.substring(0,len-1)+"b";

        return res;
        */
    }
}
