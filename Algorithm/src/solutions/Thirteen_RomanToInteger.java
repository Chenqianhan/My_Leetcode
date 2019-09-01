package solutions;

public class Thirteen_RomanToInteger {
    public int romanToInt(String s) {
        int count=0;
        //循环不能从零开始,因为I都在后面,否则无法判断,得先从小的开始.
        //Swith不能忘了加break
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            switch(c){
                case 'I':
                    count+=(count>=5?-1:1);
                    break;
                case 'V':
                    count+=5;
                    break;
                case 'X':
                    count+=10*(count>=50?-1:1);
                    break;
                case 'L':
                    count+=50;
                    break;
                case 'C':
                    count+=100*(count>=500?-1:1);
                    break;
                case 'D':
                    count+=500;
                    break;
                case 'M':
                    count+=1000;
                    break;
            }
        }
        return count;
    }
}
