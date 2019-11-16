package solutions;
//Similar to No.10 Regular Expression Matching, using DP.
//Runtime 12ms faster than 53.83%. Memory 37.7MB less than 95.35%.
public class FortyFour_wildcardMatching {
    public boolean isMatch(String s, String p) {
        int sLength=s.length();
        int pLength=p.length();
        boolean[][] result=new boolean[sLength+1][pLength+1];
        result[0][0]=true;
        for(int i=1;i<=pLength;i++){
            if(p.charAt(i-1)=='*') result[0][i]=result[0][i-1];
        }

        for(int row=1;row<=sLength;row++){
            for(int col=0;col<=pLength;col++){
                if(col>0 && (s.charAt(row-1)==p.charAt(col-1) || p.charAt(col-1)=='?')){
                    result[row][col]=result[row-1][col-1];
                }else if(col>0 && p.charAt(col-1)=='*'){
                    result[row][col]=result[row-1][col] || result[row][col-1];
                }else result[row][col]=false;
            }
        }

        return result[sLength][pLength];
    }
}
