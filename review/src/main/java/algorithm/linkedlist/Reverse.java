package algorithm.linkedlist;

public class Reverse {
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null )
            return head;
        ListNode next = null;
        ListNode pre = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = reverse(head);
        while (newHead!=null){
            System.out.print(newHead.val+"->");
            newHead = newHead.next;
        }
    }
}
