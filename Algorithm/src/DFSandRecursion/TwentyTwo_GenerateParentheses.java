package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;

public class TwentyTwo_GenerateParentheses {
    List<String> arr=new ArrayList<>();

    public void Generator(int left, int right, String s){
        if(left==0 && right==0){
            arr.add(s);
            return;
        }

        if(left>0) Generator(left-1,right,s+"(");

        if(right>0 && right>left) Generator(left,right-1,s+")");
    }

    public List<String> generateParenthesis(int n) {
        if(n==0){
            arr.add("");
            return arr;
        }
        Generator(n,n,"");
        return arr;
    }
}
