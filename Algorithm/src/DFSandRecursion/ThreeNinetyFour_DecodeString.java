package DFSandRecursion;

import java.util.Comparator;

//Recursion.
public class ThreeNinetyFour_DecodeString {
    //One mistake I made: Ignoring cnt can be accumulated by several consecutive char.
    private int idx = -1;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(++idx<s.length()){
            char c = s.charAt(idx);
            if(Character.isDigit(c))
                cnt = cnt * 10 + c - '0';
            else if(c==']')
                return sb.toString();
            else if(c=='['){
                String tmp = decodeString(s);
                //for(int j=0;j<cnt;j++)
                while(cnt>0){
                    sb.append(tmp);
                    cnt--;
                }
                //cnt=0;
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
