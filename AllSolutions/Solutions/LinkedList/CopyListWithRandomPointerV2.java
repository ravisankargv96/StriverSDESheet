package Solutions.LinkedList;

public class CopyListWithRandomPointerV2 {
    // Definition for a Node.
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        //first form the list with current nodes and new nodes
        // if list is 1->2->3
        // we make it 1->1->2->2->3->3
        Node curr = head;
        while(curr != null) {
            Node n = new Node(curr.val);
            n.next = curr.next;
            curr.next = n;
            curr = curr.next.next;
        }

        //Now we have actual nodes and new Nodes
        // understand this clearly first
        // curr.next.random = curr.random.next;

        curr = head;
        while(curr!=null) {
            if(curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //separate out both the lists and return the new list
        curr = head;
        Node curr1 = head.next;
        Node h = curr1;
        while(curr != null) {
            curr.next = curr.next.next;
            if(curr1.next != null) {
                curr1.next = curr1.next.next;
            }
            curr = curr.next;
            curr1 = curr1.next;
        }
        return h;
    }
}
