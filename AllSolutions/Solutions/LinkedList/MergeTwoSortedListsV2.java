package Solutions.LinkedList;

public class MergeTwoSortedListsV2 {

    //Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode last = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }

        if (l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return preHead.next;
    }

    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoListsRec(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoListsRec(l1, l2.next);
        }
        return mergeHead;
    }
}