package StackAndHeap;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TenNineteen_NextGreaterNodeInLinkedList {
    //This solution is quite similar as 1130 in Greedy.
    public int[] nextLargerNodes(ListNode head) {
        //Stack<ListNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int i=res.length-1;i>=0;i--){
            int cur = list.get(i);
            while(cur>=stack.peek()){
                stack.pop();
            }
            res[i]=stack.peek()==Integer.MAX_VALUE?0:stack.peek();
            stack.push(cur);
        }

        return res;
    }

}
