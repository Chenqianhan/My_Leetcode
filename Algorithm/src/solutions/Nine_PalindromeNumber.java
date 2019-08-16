package solutions;

//Solution in mathematics.
public class Nine_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0&&x%10==0)) return false;
        int rev=0;
        while(x>rev){
            rev=rev*10+x%10;
            x=x/10;
        }
        return (x==rev||x==rev/10);
    }
}
/* Solution in String.
class Nine_PalindromeNumber {
    public boolean isPalindrome(int x) {
        //int -> String: s=String.valueOf(i)
        //String -> int: i=Integer.parseInt(s);
        String s=String.valueOf(x);
        int index=s.length()-1;
        for(int i=0;i<index;i++){
            if(s.charAt(i)!=s.charAt(index)) return false;
            index--;
        }
        return true;
    }
}
*/