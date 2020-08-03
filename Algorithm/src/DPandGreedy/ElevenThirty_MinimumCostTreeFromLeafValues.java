package DPandGreedy;

import java.util.Stack;

public class ElevenThirty_MinimumCostTreeFromLeafValues {
    //Basic idea: 1. Larger number is used as late as possible. 2. Control depth of the tree.
    //DP like 312 is brute force. Kind of inefficient for those problems that have cue for best answer.

    //There are 3 kinds of arr. 1. Descending order 2. Ascending order 3.No order.
    //For 1, we only need to multiple the last two one by one.
    //For 2, smaller one need to be counted first.
    //Greedy.
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE); //Kind of ballast

        //Remove and count all adjacently ascending numbers.
        for(int num:arr){
            //Because of it, numbers in stack are in descending order
            while(num>=stack.peek()){
                //Drop is the smallest one among num, itself and peek().
                int drop = stack.pop();
                res+=drop*Math.min(stack.peek(),num);
            }
            //No matter num and peek() which is smaller. They are potential used subsequently.
            stack.push(num);
        }

        //This step is to solve remaining descending number.
        while(stack.size()>2){
            res+=stack.pop()*stack.peek();
        }
        return res;
    }
}
