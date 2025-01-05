package Solutions.LinkedList.DetectACycle;

import java.util.HashMap;
import java.util.Map;

import Solutions.Blocks.ListNode;

public class BruteForce {

    public static boolean detectLoop(ListNode head){

        ListNode temp = head;

        // Instead of Map we can also use HashSet
        Map<ListNode, Integer> nodeMap = new HashMap<>();

        while(temp != null){

            if(nodeMap.containsKey(temp)){
                return true;
            }

            // Store the current node in the map
            nodeMap.put(temp, 1);

            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Check if there is a loop
        // in the linked list
        if (detectLoop(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

}
