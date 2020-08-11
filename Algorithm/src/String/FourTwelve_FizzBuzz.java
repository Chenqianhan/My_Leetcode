package String;

import java.util.ArrayList;
import java.util.List;

public class FourTwelve_FizzBuzz {
    //Optimized
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                res.add("FizzBuzz");
            }else if(i%3==0){
                res.add("Fizz");
            }else if(i%5==0){
                res.add("Buzz");
            }else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
    /*
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String tmp = "";
        for(int i=1;i<=n;i++){
            if(i%3==0 || i%5==0){
                if(i%15==0){
                    tmp = "FizzBuzz";
                }else if(i%3==0){
                    tmp = "Fizz";
                }else{
                    tmp = "Buzz";
                }
            }else{
                tmp = String.valueOf(i);
            }
            res.add(tmp);
        }
        return res;
    }
    */
}
