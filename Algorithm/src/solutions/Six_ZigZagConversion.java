package solutions;

public class Six_ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] c=s.toCharArray();
        int len=c.length;
        StringBuilder[] sb=new StringBuilder[numRows];

        //Initialize each elements in sb[].
        for(int i=0;i<sb.length;i++) sb[i]=new StringBuilder();

        int count=0;
        while(count<len){
            //Vertically down.
            for(int index=0;index<numRows&&count<len;index++){
                sb[index].append(c[count]);
                count++;
            }
            //Vertically up; 如果不加i<len会超出bound
            for(int index=numRows-2;index>=1&&count<len;index--){
                sb[index].append(c[count]);
                count++;
            }
        }

        for(int index=1;index<sb.length;index++) sb[0].append(sb[index]);
        return sb[0].toString();
    }
}
