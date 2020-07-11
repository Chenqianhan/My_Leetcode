package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;

public class SeventyEight_subSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new int[nums.length], 0, 0);
        //Anotherdfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    //0ms(100%), 39.9MB(36.88%)
    public void dfs(int[] nums, List<List<Integer>> res, int[] list, int index, int start){
        List<Integer> temp = new ArrayList<>();
        for(int j=0;j<index;j++){
            //A stupid mistake: used nums but not list.
            temp.add(list[j]);
        }
        res.add(temp);

        if(index<=list.length){
            for(int i=start;i<nums.length;i++){
                list[index]=nums[i];
                dfs(nums, res, list, index+1, i+1);
            }
        }
    }

    //1ms(66.28%), 40.4MB(14.62%)
    public void Anotherdfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int start){
        //Another stupid moment: add temp directly.
        res.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            Anotherdfs(nums, res, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
