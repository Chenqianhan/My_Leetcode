package Tiktok;

import dataStructure.ListNode;

public class OneFortyEight_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode a, ListNode b){
        ListNode base = new ListNode(0), pointer = base;
        while(a != null && b != null){
            if(a.val <= b.val){
                pointer.next = a;
                a = a.next;
            }else{
                pointer.next = b;
                b = b.next;
            }

            pointer = pointer.next;
        }

        while(a != null){
            pointer.next = a;
            pointer = a;
            a = a.next;
        }

        while(b != null){
            pointer.next = b;
            pointer = b;
            b = b.next;
        }

        return base.next;
    }
}
