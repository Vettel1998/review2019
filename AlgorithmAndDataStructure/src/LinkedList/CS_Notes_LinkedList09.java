package LinkedList;

/**
 * CS_Notes_LinedList09. 分隔链表
 * Leetcode725. Split Linked List in Parts(Medium)
 */
public class CS_Notes_LinkedList09 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode cur = root;
        while (cur!=null){
            len++;
            cur = cur.next;
        }

        int width = len/k;
        int rem = len%k;

        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = cur;
            for (int j = 0; j <(width + (i < rem ? 1 : 0)-1); j++) {
                if (cur!=null) cur = cur.next;
            }
            if (cur!=null){
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;

            }
            res[i] = head;
        }
        return res;
    }
}
