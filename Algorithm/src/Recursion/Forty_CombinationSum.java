package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* ---------Solved----------
Problem: How to avoid duplicated list while allowing identical element in a list.
Unlike LC46, there are one or more identical elements.
But changing i to candidates[i], to record the element but not position doesn't work in resursive scenario.
 */

/* This condition is redundant.
if((isUsed & 1<<candidates[i])==0){
    temp.add(candidates[i]);
    dfs(candidates, target-candidates[i],temp, res, i, isUsed | 1<<candidates[i]);
    temp.remove(temp.size()-1);
}

Summary: If duplicate is not allowed, array is a better choice for temporary storage in recursive methods, cuz storage is of fixed size.
*/
public class Forty_CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //The input must be sorted, or dfs goes wrong.
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        //dfs(candidates, target, new ArrayList<>(), res, 0);
        optimizedDFS(candidates, target, res, 0, new int[candidates.length], 0);

        return res;
    }

    public void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> res, int start){
        if(target>0){
            for(int i=start;i<candidates.length;i++){
                //Implement this statement to resolve the problem below.
                //It is to avoid replicated lists.
                if(i>start && candidates[i]==candidates[i-1]) continue;

                temp.add(candidates[i]);
                //i+1 is to avoid using the element repeatedly.
                dfs(candidates, target-candidates[i],temp, res, i+1);
                temp.remove(temp.size()-1);
            }
        }else if(target==0){
            res.add(new ArrayList<>(temp));
        }
    }

    //Improvement: Cuz in this problem, duplicate element is not allowed.
    //Thus, sizes of lists are less than candidates.length+1 for sure.
    //Simply using array performs better than using List in both runtime and memory.
    public void optimizedDFS(int[] candidates, int target,List<List<Integer>> res, int start, int[] list, int listIndex){
        if(target>0){
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]) continue;

                list[listIndex]=candidates[i];
                optimizedDFS(candidates, target-candidates[i], res, i+1, list, listIndex+1);
            }
        }else if(target==0){
            List<Integer> temp = new ArrayList<>();
            //listIndex <= list.size().
            for(int i=0;i<listIndex;i++){
                temp.add(list[i]);
            }
            res.add(temp);
        }
    }
}
