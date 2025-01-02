package LinkedList;

public class MiddleNode {

    //1. Finding the length
    //2. Getting to half of the length;
    public ListNode middleNodeBruteForce(ListNode head) {

        //1. Finding the length
        int cnt = 0;

        ListNode temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        //2. Standing at 2nd half element
        temp = head;
        for(int i = 0; i < cnt/2; i++){
            temp = temp.next;
        }

        return temp;
    }

    /**
     * Slow & Fast Pointer Approach.
     * Move the fast pointer only if the next place isn't null
     * i.e. (fast.next != null && fast.next.next != null) only then move fast pointer
     * to it's next place
     * Based on Even or Odd return the pointer
     * */

    public ListNode middleNode(ListNode head){

        //mandatory null check since we are directly using fast.next
        //in the code
        if(head == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //length is odd
        if(fast.next == null){
            return slow;
        }
        return slow.next;
    }
}
