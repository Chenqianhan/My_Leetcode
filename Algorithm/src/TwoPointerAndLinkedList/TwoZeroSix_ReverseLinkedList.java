package TwoPointerAndLinkedList;

import solutions.ListNode;

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

    //Recursion with same idea.
    public ListNode reverseList(ListNode head) {
        //ListNode newHead = null;
        return recursion(head, null);
    }

    public ListNode recursion(ListNode head, ListNode newHead){
        if(head==null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        return recursion(next, newHead);
    }

}
