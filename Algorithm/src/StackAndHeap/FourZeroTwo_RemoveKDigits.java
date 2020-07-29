package StackAndHeap;

public class FourZeroTwo_RemoveKDigits {
    //Two special cases: 1."10"/1 2."10"/2. To solve this, judgement need putting at last;
    //Optimized greedy
    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        //if(digits.length<=k) return "0";
        int index = 0;
        for(char c:digits){
            while(k>0 && index>0 && c<digits[index-1]){
                index--;
                k--;
            }
            if(c!='0' || index>0)
                digits[index++]=c;
        }
        index-=k;
        //return (index==0)?"0":String.valueOf(digits,0,index);
        //Cuz when "10"/2, index can be -1;
        return (index<=0)?"0":String.valueOf(digits,0,index);
    }

    /*
    //Greedy
    public String removeKdigits(String num, int k) {
        int len=num.length();
        if(len<=k) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char c = num.charAt(i);
            while(k>0 && !stack.isEmpty() && c<stack.peek()){
                k--;
                stack.pop();
            }

            if(c!='0' || !stack.isEmpty())
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        if(sb.length()==0) return "0";
        return sb.reverse().toString().substring(0,sb.length()-k);
    }
    */
}
