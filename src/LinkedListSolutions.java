public class LinkedListSolutions {
    //Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        int cnt=0;
        for (ListNode i = head; i!=null; i=i.next){
            cnt++;
        }
        int middle = cnt/2;
        for (int i=0; i<middle; i++) {
            head=head.next;
        }
        return head;
    }
}
