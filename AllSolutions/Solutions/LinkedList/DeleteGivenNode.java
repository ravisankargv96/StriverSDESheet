package Solutions.LinkedList;

import Solutions.Blocks.ListNode;

public class DeleteGivenNode {
    public void deleteNode(ListNode node){
        if(node == null || node.next == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Complete the method
    }
}
