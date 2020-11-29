package Tiktok;

import java.util.HashSet;
import java.util.Stack;

public class FourZeroThree_FrogJump {
    public boolean canCross(int[] stones) {
        for(int i=3;i<stones.length;i++){
            if(stones[i] > stones[i-1]*2)
                return false;
        }

        HashSet<Integer> sets = new HashSet<>();
        for(int s:stones){
            sets.add(s);
        }

        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        int lastPosition = stones[stones.length-1];
        positions.push(0);
        jumps.push(0);

        while(!positions.isEmpty()){
            int curPosition = positions.pop();
            int lastJump = jumps.pop();
            for(int i = lastJump - 1; i<= lastJump+1; i++){
                if(i <= 0) continue;

                int nextPosition = curPosition + i;

                if(nextPosition == lastPosition){
                    return true;
                }else if(sets.contains(nextPosition)){
                    positions.push(nextPosition);
                    jumps.push(i);
                }
            }
        }

        return false;
    }
}
