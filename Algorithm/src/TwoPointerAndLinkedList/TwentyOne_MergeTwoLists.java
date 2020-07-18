package TwoPointerAndLinkedList;

import dataStructure.ListNode;

public class TwentyOne_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode dummy=new ListNode(0);
        ListNode pointer=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                pointer.next=l1;
                l1=l1.next;
            }else{
                pointer.next=l2;
                l2=l2.next;
            }
            pointer=pointer.next;
        }

        while(l1!=null){
            pointer.next=l1;
            l1=l1.next;
            pointer=pointer.next;
        }

        while(l2!=null){
            pointer.next=l2;
            l2=l2.next;
            pointer=pointer.next;
        }

        return dummy.next;
    }
}
