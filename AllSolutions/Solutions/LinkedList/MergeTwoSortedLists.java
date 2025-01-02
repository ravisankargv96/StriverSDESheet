package Solutions.LinkedList;

import Solutions.Blocks.ListNode;

public class MergeTwoSortedLists {

    public ListNode iterative(ListNode l1, ListNode l2){

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

    public ListNode recursive(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = recursive(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = recursive(l1, l2.next);
        }
        return mergeHead;
    }

    private void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Complete the code
    }
}
