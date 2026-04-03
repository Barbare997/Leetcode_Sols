import java.util.Objects;

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

    //Middle of the Linked List, two pointers approach
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int carry = 0;
        int curr;
        ListNode current = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null)
                curr = l1.val + l2.val + carry;
            else curr = Objects.requireNonNullElse(l1, l2).val + carry;

            if (curr >= 10) {
                carry = curr / 10;
                curr = curr % 10;
            } else
                carry = 0;
            current.next = new ListNode(curr);
            current = current.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry!=0)
            current.next = new ListNode(carry);
        return result.next;
    }
}
