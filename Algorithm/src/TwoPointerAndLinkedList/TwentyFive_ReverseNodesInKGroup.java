package TwoPointerAndLinkedList;

import dataStructure.ListNode;

public class TwentyFive_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = head;
        for(int i=0;i<k;i++){
            if(dummy == null) return head;
            dummy = dummy.next;
        }

        ListNode pre = head, cur = head.next;
        for(int i = 1;i<k;i++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        head.next = reverseKGroup(dummy, k);
        return pre;
    }
}
