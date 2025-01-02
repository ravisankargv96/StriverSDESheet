package Solutions.LinkedList;

//Check the pdf solution for explanation

import Solutions.Blocks.ListNode;

public class PalindromeCheck {

    public static ListNode reverseList(ListNode head) {
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
    
    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean checkListNodes(ListNode first, ListNode second) {
        while(second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;  
        }
        
        
        ListNode prev = getMiddleNode(head);
        ListNode curr = prev.next;
        prev.next = null;

        ListNode newHead = reverseList(curr);

        return checkListNodes(head, newHead);
    }
    
}
