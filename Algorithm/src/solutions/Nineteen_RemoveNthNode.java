
package solutions;

import dataStructure.ListNode;

public class Nineteen_RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0); //dummy is to mark the zero;
        dummy.next=head;
        int length=0;
        ListNode pointer=head;
        while(pointer.next!=null){
            pointer=pointer.next;
            length++;
        }
        length-=(n-1);

        //Aware of the last nth position, we don't need head any more
        pointer=dummy;
        while(length>0){
            pointer=pointer.next;
            length--;
        }

        //Now the pointer's position is right before the target
        //Then bypass the target
        pointer.next=pointer.next.next;
        return dummy.next;
    }
}
