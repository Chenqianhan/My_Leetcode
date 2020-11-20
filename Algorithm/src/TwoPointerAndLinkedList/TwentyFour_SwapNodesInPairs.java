package TwoPointerAndLinkedList;

import dataStructure.ListNode;

public class TwentyFour_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;

        return node;
    }
}
