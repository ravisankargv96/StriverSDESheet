package FunctionsBlocks;

class ListNode{
    public int x;
    public ListNode next;

    ListNode(int x){
        this.x = x;
        this.next = null;
    }

    ListNode(int x, ListNode next){
        this.x = x;
        this.next = next;
    }
}