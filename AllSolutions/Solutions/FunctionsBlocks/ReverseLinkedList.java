package FunctionsBlocks;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head){

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
    public ListNode createLinkedList(int size){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i = 0; i<size; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return dummy.next;
    }
    public void printLinkedList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.x + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
    public void execute(){

        int size = 10;
        ListNode head = createLinkedList(size);
        System.out.println("Linked List of size " + size + " is created");
        printLinkedList(head);
        // reverse the linked list
        System.out.println("Reversing the list");
        head = reverse(head);
        printLinkedList(head);

    }
    public static void main(String[] args){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.execute();
    }
}
