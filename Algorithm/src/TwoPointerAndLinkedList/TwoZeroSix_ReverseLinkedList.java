package TwoPointerAndLinkedList;

import solutions.ListNode;
//These three solution performs similar. 100% in runtime but 5-7% in memory
public class TwoZeroSix_ReverseLinkedList {
    /*
    //Iteration
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
    */

    /*
    //Recursion with same idea.
    public ListNode reverseList(ListNode head) {
        return recursion(head, null);
    }

    public ListNode recursion(ListNode head, ListNode newHead){
        if(head==null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        return recursion(next, newHead);
    }
    */

    //Two-pointer
    public ListNode reverseList(ListNode head){
        if(head==null) return head;
        int size = 0;
        ListNode index = head;
        while(index!=null){
            size++;
            index = index.next;
        }
        ListNode[] list = new ListNode[size];
        index = head;
        for(int i=0;i<size;i++){
            list[i]=index;
            index=index.next;
        }

        list[0].next=null;
        for(int left=1, right=size-1;left<=right;left++,right--){
            list[right].next = list[right-1];
            list[left].next = list[left-1];
        }
        return list[size-1];
    }

}
