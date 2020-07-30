package String;

import java.util.LinkedList;
import java.util.Queue;

public class ElevenSixtyThree_LastSubstringInLexicographicalOrder {
    //11ms(80%),44MB(11%) is the best I can do.
    public String lastSubstring(String s) {
        //char[] strs = s.toCharArray();
        char max = 'a';
        int len = s.length();
        if(len==0) return s;

        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c>max) max = c;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<len;i++){
            //Deal with conern case: 'aaaa...'.
            char c = s.charAt(i);
            if(c==max && !(i>0 && c==s.charAt(i-1))) queue.offer(i);
        }

        //Among indices of maxChar, it is the hardest to decide which one is what we need. i.e. 'caacaaz'
        int maxIndex = queue.poll();
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i=1;a+i<len;i++){
                //if(a+i==len) break;
                if(s.charAt(maxIndex+i)<s.charAt(a+i)){
                    maxIndex = a;
                    break;
                }else if(s.charAt(maxIndex+i)>s.charAt(a+i)){
                    break;
                }
            }
        }

        //return String.valueOf(strs,maxIndex,strs.length);
        return s.substring(maxIndex,len);
    }
    /*
    //51%,8.33&
    public String lastSubstring(String s) {
        char[] strs = s.toCharArray();
        char max = 'a';
        for(char c:strs){
            if(c>max) max = c;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<strs.length;i++){
            //Deal with conern case: 'aaaa...'.
            if(strs[i]==max && !(i>0 && strs[i]==strs[i-1])) queue.offer(i);
        }

        int maxIndex = queue.poll();
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i=1;i<a-maxIndex;i++){
                if(a+i==strs.length) break;
                if(strs[maxIndex+i]<strs[a+i]){
                    maxIndex = a;
                    break;
                }else if(strs[maxIndex+i]>strs[a+i]){
                    break;
                }
            }
        }

        //return String.valueOf(strs,maxIndex,strs.length);
        return s.substring(maxIndex,strs.length);
    }
    */

    /*
    //TLE
    public String lastSubstring(String s) {
        char[] strs = s.toCharArray();
        char max = 'a';
        int lastIndex = 0, len = s.length();
        for(int i=0;i<len;i++){
            char c = strs[i];
            if(c>max){
                max = c;
                lastIndex=i;
            }else if(c==max){
                while(i<len){
                    int tmp = 1;
                    if(strs[lastIndex+tmp]>strs[i+tmp]){
                        break;
                    }else if(strs[lastIndex+tmp]<strs[i+tmp]){
                        lastIndex = i;
                        break;
                    }
                    tmp++;
                }
            }
        }
        return String.valueOf(strs,lastIndex,len);
    }
    */
}
