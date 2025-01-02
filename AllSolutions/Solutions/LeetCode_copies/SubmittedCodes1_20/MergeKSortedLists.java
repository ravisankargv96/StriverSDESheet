package LeetCode_copies.SubmittedCodes1_20;

import java.util.*;

public class MergeKSortedLists {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 1st Parameter - Given Array of LinkedLists
        //2nd Parameter - Starting index (0)
        //3rd Parameter - End index (length of array - 1)

        return recur (lists, 0, lists.length-1);
    }

    //Recursive Function
    ListNode recur (ListNode [] lists, int start, int end) {
        if (start > end)       // Checks the Corner Case where array is empty
            return null;
        if (start == end)    // Base Case where the Number of list here is just One (1)
            return lists[start];    //Basically return it

        int mid = (start + end)/2;     //Gets the mid index of length of array;

        ListNode L1 = recur(lists, start, mid);       //Splits array to the left of mid (mid inclusive)
        ListNode L2 = recur(lists, mid+1, end);    // Splits array to the right of mid

        return mergeTwoSorted (L1, L2);   // Basically merge the two lists found
    }

    // Algorithm for mergeTwoSortedLinkedLists

    ListNode mergeTwoSorted (ListNode L1, ListNode L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;

        ListNode headDummy = new ListNode(0),
                tail = headDummy;

        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                tail.next = L1;
                L1 = L1.next;
            } else {
                tail.next = L2;
                L2 = L2.next;
            }
            tail = tail.next;
        }

        if (L1 == null)
            tail.next = L2;
        else
            tail.next = L1;

        return headDummy.next;
    }
}

