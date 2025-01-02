package Solutions.LinkedList;

import Solutions.Blocks.ListNode;

public class RemoveNthNode {
    /**
     * Idea:
     * Two pointers should be present
     * when fast pointer is at last node
     * slow pointer should be standing before the removed node
     *
     * Here: dummy node is helpful,
     * incase you need to remove the first node
     * */
    public ListNode removeNthFromEnd(ListNode head, int n){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // eg. @ i = 1, fast = head;
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

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Complete the code
    }
}
