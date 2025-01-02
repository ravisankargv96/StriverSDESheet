package Solutions.LinkedList.IntersectionOfYList;

import Solutions.Blocks.ListNode;

/**
 *  T.C. O(m*n)
 *  S.C. O(1)
 * */
public class BruteForce {

    static ListNode insertNode(ListNode head, int val){

        ListNode newNode = new ListNode(val);

        if(head == null){
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    
    }
    
    //utility function to check presence of intersection
    static ListNode intersectionPresent(ListNode head1, ListNode head2){
        while(head2 != null){

            ListNode temp = head1;
            while(temp != null){
                // if both nodes are same
                if(temp == head2){
                    return temp;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }

        //intersection is not present between the lists return null
        return null;
    }
    
    //utiltiy function to print linked list created
    static void printList(ListNode head){
        while(head.next != null){
            System.out.println(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        // creation of both lists
        
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        
        ListNode head1 = head;
        head = head.next.next.next;
        ListNode headSec = null;
        headSec = insertNode(headSec, 3);
        ListNode head2 = headSec;
        headSec.next = head;
        
        //printing of the lists
        System.out.println("List1: ");
        printList(head1);
        System.out.println("List2: ");
        printList(head2);
        
        //checking if intersection is present
        ListNode answerNode = intersectionPresent(head1, head2);
        if(answerNode != null){
            System.out.println("Intersection found at: " + answerNode.val);
        } else{
            System.out.println("No intersection");
        }
    }
}
