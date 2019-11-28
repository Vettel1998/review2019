package LinkedList;

/**
 * leetcode 21. Merge Two Sorted Lists (Easy)
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * CS_Notes_LinkedList03
 */
public class CS_Notes_LinkedList03 {

    // 自己迭代版本
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = l1;
        if (l2.val<l1.val){
            res = l2;
            l2 = l2.next;
        }
        else {
            l1 = l1.next;
        }

        ListNode ret = res;

        while (l1 != null || l2 != null) {
            int v1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int v2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if (v1<v2){
                res.next = l1;
                l1 = l1.next;
            }else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        return ret;
    }


    //dummy哑节点迭代版本
    public ListNode mergeTwoListsDummy(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null)
            cur.next = l2;
        else cur.next = l1;

        return dummyNode.next;
    }
}
