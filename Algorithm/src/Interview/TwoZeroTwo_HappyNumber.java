package Interview;

import java.util.HashSet;
import java.util.Set;

public class TwoZeroTwo_HappyNumber {
    //False condition is that a circle presents while it is not 1;
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = getNxt(n);
        }
        return n==1;
    }

    public int getNxt(int n){
        int sum = 0;
        while(n>0){
            int cur = n%10;
            n /= 10;
            sum += cur*cur;
        }
        return sum;
    }
}
