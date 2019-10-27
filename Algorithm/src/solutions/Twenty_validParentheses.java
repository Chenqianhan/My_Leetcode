package solutions;

import java.util.Stack;

public class Twenty_validParentheses {
    public boolean isValid(String s){
        /*
        String[] arr=s.split("");
        Stack<String> stack=new Stack<>();

        for(String c:arr){
            System.out.println(c);
            if(c.equals("(") || c.equals("{") || c.equals("[")){
                stack.push(c);
                System.out.println(c);
            }else if(c.equals(")")){
                if(stack.peek().equals("(")){
                    stack.pop();
                }else return false;
            }else if(c.equals("}")){
                if(stack.peek().equals("{")){
                    stack.pop();
                }else return false;
            }else if(c.equals("]")){
                if(stack.peek().equals("[")){
                    stack.pop();
                }else return false;
            }else return false;
        }

        if(!stack.empty()) return false;

        return true;
        */
        //It's much more faster than previous with lower runtime and memory occupation.
        if(s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();
        //Some mistakes I made:1.Forgot stackEmptyException; 2. char should not use equals() but == 3. When ""
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if(!stack.empty() && s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
            }else if(!stack.empty() && s.charAt(i)=='}' && stack.peek()=='{'){
                stack.pop();
            }else if(!stack.empty() && s.charAt(i)==']' && stack.peek()=='['){
                stack.pop();
            }else return false;
        }

        if(!stack.empty()) return false;

        return true;
    }
}
