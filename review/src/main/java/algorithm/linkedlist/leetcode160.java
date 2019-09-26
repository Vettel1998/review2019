package algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set1 = new HashSet<>();
        while (headA!=null){
            set1.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set1.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }

    public ListNode intersection2(ListNode headA,ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb){
            pa = (pa==null)?headB:pa.next;
            pb = (pb==null)?headA:pb.next;
        }
        return pa;
    }

    public static void main(String[] args) {

    }
}
