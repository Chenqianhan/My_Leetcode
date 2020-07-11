package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;

//To do: There is also a backtrack way to solve this. And compare it with LC46.
//Backtrack is quite the same as dfs.
public class ThirtyNine_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Only if the candidates is not sorted.
        //Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    //Initially, I use parameter 'sum', which can be replaced by target's reduction.
    public void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> res, int start){
        if(target == 0) {
            //res.add(temp);
            res.add(new ArrayList<>(temp));
        }else if(target > 0){
            //If i started from 0, there would be replicated list in different order.
            for(int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                dfs(candidates, target-candidates[i], temp, res, i);
                //This is backtrack.
                temp.remove(temp.size()-1);
            }
        }
    }
}
