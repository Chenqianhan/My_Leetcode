package solutions;

import java.util.*;

public class Seventeen_LetterToNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        List<String> output=new ArrayList<String>();
        Stack<String> s1=new Stack<String>();
        Stack<String> s2=new Stack<String>();
        Map<Character,List<String>> map=new HashMap<Character, List<String>>();
        //map can replace switch in this situation
        if(digits.contains("2")) map.put('2',Arrays.asList("a","b","c")); //Convert an array into list
        if(digits.contains("3")) map.put('3',Arrays.asList("d","e","f"));
        if(digits.contains("4")) map.put('4',Arrays.asList("g","h","i"));
        if(digits.contains("5")) map.put('5',Arrays.asList("j","k","l"));
        if(digits.contains("6")) map.put('6',Arrays.asList("m","n","o"));
        if(digits.contains("7")) map.put('7',Arrays.asList("p","q","r","s"));
        if(digits.contains("8")) map.put('8', Arrays.asList("t","u","v"));
        if(digits.contains("9")) map.put('9',Arrays.asList("w","x","y","z"));
        //Push the first layer into stack.
        for(String i:map.get(digits.charAt(0))){
            s1.push(i);
        }
        if(digits.length()>=2){
            for(int i=1;i<digits.length();i++){
                List<String> temp=map.get(digits.charAt(i));
                while(!s1.isEmpty()){
                    String str=s1.pop();
                    for(String j:temp) s2.push(str+j);
                }
                while(!s2.isEmpty()) { s1.push(s2.pop()); }
            }
        }
        while(!s1.isEmpty()) output.add(s1.pop());

        return output;
    }
}

