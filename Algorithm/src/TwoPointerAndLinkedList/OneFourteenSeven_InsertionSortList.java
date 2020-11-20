package TwoPointerAndLinkedList;

import dataStructure.ListNode;

public class OneFourteenSeven_InsertionSortList {
    //Create an new list to add nodes of current list one by one in order.
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode cur = head, pre, nxt;
        while(cur!=null){
            pre = newHead;
            nxt = newHead.next;
            while(nxt!=null){
                if(cur.val < nxt.val) break;
                pre = pre.next;
                nxt = nxt.next;
            }

            ListNode tmp = cur.next;
            cur.next = nxt;
            pre.next = cur;

            cur = tmp;
        }

        return newHead.next;
    }
}
