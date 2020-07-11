package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;

public class SeventySeven_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new int[k], res, n, k, 1, 0);
        return res;
    }

    //Same solution as LC40
    public void dfs(int[] list, List<List<Integer>> res, int n, int k, int start, int index){
        if(index<k){
            for(int i=start;i<n+1;i++){
                list[index]=i;
                dfs(list, res, n, k, i+1, index+1);
                //Big mistake, it generates type of [n,n] form.
                //dfs(list, res, n, k, start+1, index+1);
            }
        }else if(index==k){
            List<Integer> temp = new ArrayList<>();
            //Cuz the number of elements is fixed. Thus we can iterate all elements in list.
            for(int i:list){
                temp.add(i);
            }
            res.add(temp);
        }
    }

}
