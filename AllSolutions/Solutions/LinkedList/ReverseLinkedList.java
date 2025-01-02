package LeetCode60Questions.LinkedList;

public class ReverseLinkedList {

    //Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {

        //My Iterative Solution
        public ListNode reverseList(ListNode head) {

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

        //Recursive solution
        public ListNode reverseListSol2(ListNode head) {
            /* recursive solution */
            return reverseListRecur(head, null);
        }

        private ListNode reverseListRecur(ListNode head, ListNode newHead) {
            if (head == null)
                return newHead;
            ListNode next = head.next;
            head.next = newHead;
            return reverseListRecur(next, head);
        }
    }
}
