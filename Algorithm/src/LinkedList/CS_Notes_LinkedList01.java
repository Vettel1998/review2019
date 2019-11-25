package LinkedList;


import java.util.List;

/**
 *  CS_NOTES 链表1. 找出两个链表的交点
 *  leetcode160. Intersection of Two Linked Lists (Easy)
 */
public class CS_Notes_LinkedList01 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode aPointer = headA;
        ListNode bPointer = headB;

        while (aPointer!=bPointer){

            //三元表达式重构
           /* if (aPointer.next == null) aPointer = headB;
            else aPointer = aPointer.next;
            if (bPointer.next == null) bPointer = headA;
            else bPointer = bPointer.next;*/
           aPointer = (aPointer==null)?headB:aPointer.next;
           bPointer = (bPointer==null)?headA:bPointer.next;

        }

        return aPointer;
    }


    //如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环。
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

}
