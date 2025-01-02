package SubmittedCodes41_60.ReverseLinkedList;

import java.util.*;

public class ReverseLinkedList {

    //write the recursive solution also
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

}
