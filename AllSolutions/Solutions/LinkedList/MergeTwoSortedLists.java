package LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode temp = dummy;

        while(head1 != null && head2 != null){

            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if(head1 != null){
            temp.next = head1;
        }

        if(head2 != null){
            temp.next = head2;
        }

        return dummy.next;
    }
}
