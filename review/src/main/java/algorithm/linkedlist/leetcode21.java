package algorithm.linkedlist;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode ret = res;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                res.next = l2;
                l2 = l2.next;
            }else {
                res.next = l1;
                l1 = l1.next;
            }
            res = res.next;
        }
        res.next = (l1==null)?l2:l1;
        return ret.next;
    }
}
