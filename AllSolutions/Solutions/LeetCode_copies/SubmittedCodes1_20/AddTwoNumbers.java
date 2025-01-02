package LeetCode_copies.SubmittedCodes1_20;

public class AddTwoNumbers {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {

        ListNode l3 = new ListNode();
        ListNode temp = new ListNode();
        temp=l3;
        //extracting numbers from both the linked list and adding them and putting them in the resulted list
        int carry=0;
        ListNode templ1 = new ListNode();
        ListNode templ2 = new ListNode();
        ListNode temps = new ListNode();
        templ1=l1;
        templ2=l2;
        while(templ1!=null || templ2!=null || carry>0)
        {
            ListNode temp1 = new ListNode();
            int d;
            int d1;
            if(templ1!=null)
            {
                d= templ1.val;
                temps=templ1.next;
                templ1=temps;
            }
            else
                d=0;
            if(templ2!=null)
            {
                d1=templ2.val;
                temps=templ2.next;
                templ2=temps;
            }
            else
                d1=0;
            int sum=d+d1+carry;
            if(sum>9)
            {
                int t;
                t=sum%10;
                carry=sum/10;
                sum=t;
            }
            else
                carry=0;
            temp.val=sum;
            if(templ1!=null || templ2!=null || carry>0)
            {
                temp.next=temp1;
                temp=temp.next;
            }
        }
        return l3;
    }
}
// here we need to maintain the carry and we need to add carry in next set of numbers if carry is also 0 and the both linked list is also null ,, then loop terminates.```
