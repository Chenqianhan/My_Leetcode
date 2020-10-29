package Array;

import java.util.ArrayList;
import java.util.List;

public class OneEighteen_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        //Actually we don't have to
        for(int i = 0; i< numRows; i++){
            level.add(0, 1); //Increment 1 for each level;

            for(int j = 1;j < level.size()-1; j++){
                level.set(j, level.get(j)+level.get(j+1));
            }

            list.add(new ArrayList<>(level));
        }

        return list;
    }
}
