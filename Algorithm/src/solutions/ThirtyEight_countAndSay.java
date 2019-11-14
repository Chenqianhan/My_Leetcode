package solutions;
//This problem is sometimes hard to understand literally. It means we count the previous number iteratively.
//i.e. 1->1, 2->11, 3->21, 4->1211, we can interpret from 4. 4 means there are two '1' and one '1' on 3. 3 means two '1' on 2.
public class ThirtyEight_countAndSay {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String s="1";
        if(n==1) return s;

        StringBuilder sb=new StringBuilder();
        //I just put n>1 and n-- together into n-->1.
        //The while loop means we need to iterate the string from 1 to n.
        while(n-->1){
            char pointer=s.charAt(0);
            int count=1;
            //Note: StringBuilder can be cleaned by setLength(0). By this way we don't need to repeatedly define StringBuilder.
            sb.setLength(0);
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)==pointer) count++;
                else{
                    sb.append(count).append(pointer);
                    pointer=s.charAt(i);
                    count=1;
                }
            }
            sb.append(count).append(pointer);
            s=sb.toString();
        }

        return s;
    }
}
