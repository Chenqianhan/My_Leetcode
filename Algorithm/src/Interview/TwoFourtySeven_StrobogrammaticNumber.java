package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoFourtySeven_StrobogrammaticNumber {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }

    public List<String> helper(int n, int rest){
        if(rest==0) return new ArrayList<String>(Arrays.asList(""));
        if(rest==1) return new ArrayList<String>(Arrays.asList("0","1","8"));

        List<String> list = helper(n, rest-2);
        List<String> res = new ArrayList<>();
        for(String s:list){
            if(n!=rest) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }
}
