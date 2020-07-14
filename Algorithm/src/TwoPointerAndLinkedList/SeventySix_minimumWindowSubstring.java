package TwoPointerAndLinkedList;

/**
 * Mistake I made:
 * 1. Concerning repeat and required character in s that may cause failure.
 * Answer: the count of character is based on t, such as "BBAC" and "BA", in which win[B]=1.
 * Thus repeat character will not interrupt it.
 *
 * Annotation:
 * non-required element's count is initially 0, when right comes to it, it--.
 * Then it++ when left comes to it. Thus it will never larger than 0.
 *
 * required element: in  "BBAC" and "BA", we may concern about it fails to contract.
 * When windows is "BB", the count is 1, win[B] is -1.
 * When windows is "BBA", the count is 0 -> ++win[b]=0, left++, ++win[b]=1, then count len.
 *
 */
public class SeventySix_minimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s==null || t==null) return "";
        int[] win = new int[128];
        for(char c:t.toCharArray())
            win[c]+=1;

        //String res = "";
        int begin = 0;
        int len = Integer.MAX_VALUE, count=t.length();
        //Expanding window
        for(int left=0,right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(--win[c]>=0) count--;
            //Contracting window
            while(count==0){
                char d = s.charAt(left);
                //When left is pointed to a char in t.
                win[d]++;
                if(win[d]>0){
                    if(len>right-left+1){
                        len = right-left+1;
                        //Recording begin is a little faster than recording res.
                        begin = left;
                        //res = s.substring(left, right+1);
                    }
                    count++;
                }
                left++;
            }
        }
        return (len == Integer.MAX_VALUE)?"":s.substring(begin, begin+len);
        //return res;
    }
}
