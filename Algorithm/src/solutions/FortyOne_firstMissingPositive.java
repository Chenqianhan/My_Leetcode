package solutions;
import java.util.ArrayList;
import java.util.List;
//It's resolved easily by List. I write it in 1 minute but it's hard. Weird.
//The runtime is 1ms faster than 37.6%. Memory is 34.6MB less than 100%.

public class FortyOne_firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums) list.add(num);
        int i=1;
        while(true){
            if(list.contains(i)) i++;
            else return i;
        }

    }
}
