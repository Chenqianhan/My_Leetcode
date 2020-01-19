package solutions;

public class Seven_ReverseInteger {
    public int reverse(int x) {
        int rev=0;
        while(x!=0){
            int newRev=rev*10+x%10;
            if((newRev-x%10)/10!=rev) return 0;
            rev=newRev;
            x/=10;
        }
        return rev;
    }
}
