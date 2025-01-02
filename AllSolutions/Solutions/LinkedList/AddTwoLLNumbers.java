package LinkedList;

public class AddTwoLLNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;

        ListNode temp = dummy;

        while(temp1 != null || temp2 != null){
            int a = temp1 != null ? temp1.val : 0;
            int b = temp2 != null ? temp2.val : 0;

            int sum = (a + b + carry)%10;
            carry = (a + b + carry)/10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }

        if(carry == 1){
            temp.next = new ListNode(carry);
            carry = 0;
        }

        return dummy.next;
    }
}
