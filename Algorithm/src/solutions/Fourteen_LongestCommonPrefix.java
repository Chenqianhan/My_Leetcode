package solutions;

public class Fourteen_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int size=strs.length;
        if(size==0) return "";
        if(size==1) return strs[0];
        StringBuilder sb=new StringBuilder("");
        int i=0;
        while(true) {
            int ascii=0;
            if(i>=strs[0].length()) return sb.toString();
            int coord=strs[0].charAt(i);
            char letter=strs[0].charAt(i);
            for(int j=0;j<size;j++){
                try{
                    if(strs[j].charAt(i)!=coord) return sb.toString();
                }catch (Exception e){
                    return sb.toString();
                }
            }
            sb.append(letter);
            i++;
        }
    }
}
