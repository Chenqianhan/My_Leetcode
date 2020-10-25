package TwoPointerAndLinkedList;

import java.util.ArrayList;
import java.util.List;

public class SevenSixtyThree_PartitionLabels {
    //Greedy Two Pointer. determine the part until it is no longer stretch.
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        char[] strs = S.toCharArray();

        for(int i=0;i<strs.length;i++){
            last[strs[i]-'a'] = i;
        }

        int j = 0, anchor = -1;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            j = Math.max(j, last[strs[i]-'a']);
            if(i==j){ //No longer stretch.
                res.add(i-anchor);
                anchor = i;
            }
        }

        return res;
    }
}
