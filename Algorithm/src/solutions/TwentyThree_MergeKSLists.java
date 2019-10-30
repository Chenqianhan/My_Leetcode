package solutions;

import java.util.PriorityQueue;

public class TwentyThree_MergeKSLists {
    /*
    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ListNode dummy=new ListNode(0);
        ListNode pointer=dummy;
        for(ListNode l:lists){
            while(l!=null){
                pq.add(l.val);
                l=l.next;
            }
        }
        while(!pq.isEmpty()){
            pointer.next=new ListNode(pq.poll());
            pointer=pointer.next;
        }
        return dummy.next;
    }
    */

    //A faster way than PriorityQueue;
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0) return null;
        int interval=1;

        while(interval<lists.length){
            for(int i=0;i<(lists.length-interval);i+=interval*2){
                lists[i]=merge(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val<=l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
