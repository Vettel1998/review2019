package LinkedList;


/**
 * CS_Notes_LinkedList08. 回文链表
 * Leetcode234. Palindrome Linked List (Easy)
 */
public class CS_Notes_LinkedList08 {

    //快慢指针 将前半段翻转
    public static boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) return true;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode next = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast!=null){
            slow = slow.next;
        }
        /*System.out.println("pre:"+pre.val);
        System.out.println("pre.next:"+pre.next.val);
        System.out.println("slow:"+slow.val);
        System.out.println("slow.next:"+slow.next.val);
        System.out.println("next:"+next.val);*/

        while (slow!=null&&pre!=null){
            if (slow.val!=pre.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(1);
        isPalindrome(head1);
    }
}
