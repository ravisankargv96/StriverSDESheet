package LinkedList;

public class RemoveNthNodeOfLL {
    /**
     * Idea:
     * Two pointers should be present
     * when fast pointer is at last node
     * slow pointer should be standing before the removed node
     *
     * Here: dummy node is helpful,
     * inchance you wanna remove first node
     * */
    public ListNode removeNthFromEnd(ListNode head, int n){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // at i = 1, fast = head;
        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        // move the slow node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
