package solutions;

public class Two_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int v1=0,v2=0;
            if(l1!=null){
                v1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                v2=l2.val;
                l2=l2.next;
            }
            int sum=v1+v2+carry;
            current.next=new ListNode(sum%10);
            current=current.next;
            carry=sum/10;
        }
        return dummy.next;
    }
}
