package solutions;

import java.util.ArrayList;
import java.util.List;

public class FortySix_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        dfs(list, nums, new ArrayList<>(), 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, List<Integer> temp, int isUsed){
        if(temp.size()==nums.length){
            list.add(temp);
            //list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if((isUsed & 1<<i)==0){
                temp.add(nums[i]);
                //int tempIsUsed=isUsed;
                //List<Integer> tempTemp=new ArrayList<>(temp);
                //tempIsUsed |= 1<<i;
                dfs(list, nums, temp, isUsed | 1<<i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
