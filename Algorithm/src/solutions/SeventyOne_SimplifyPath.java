package solutions;
import java.util.Stack;

public class SeventyOne_SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length()<1){
            return "/";
        }
        Stack<String> dict=new Stack<>();
        String[] strs=path.split("/");
        for(String s: strs){
            if(s.equals(".") || s.equals("")){
                continue;
            }else if(s.equals("..")){
                if(!dict.isEmpty()) dict.pop();
            }else{
                dict.push(s);
            }
        }

        StringBuilder sb=new StringBuilder();
        if(dict.isEmpty()) sb.append("/");

        for(String s: dict){
            sb.append("/");
            sb.append(s);
        }

        return sb.toString();
    }
}
