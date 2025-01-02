package Solutions.LinkedList;

import Solutions.Blocks.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class ReverseList {

    public ListNode iterative(ListNode head) {
        // Below algo handles the edge cases i.e. head == null
        // eg. 1 -> 2 -> 3 -> 4 -> 5
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive Solution, Write a solution better than this.
    public ListNode recursive(ListNode head){

        // null Node or 1 Node
        if(head == null || head.next == null){
            return head;
        }

        ListNode newNode = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    // Recursive V2
    private ListNode recursive2(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return recursive2(next, head);
    }

    private void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseList rl = new ReverseList();
        ListNode newHead = rl.iterative(head); //Use method as per logic
        rl.printList(newHead);
    }
}
