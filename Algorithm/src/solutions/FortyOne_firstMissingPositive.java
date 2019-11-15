package solutions;
import java.util.ArrayList;
import java.util.List;
//

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
