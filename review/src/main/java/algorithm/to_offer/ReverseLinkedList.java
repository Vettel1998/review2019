package algorithm.to_offer;

import algorithm.to_offer.offer03.ListNode;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode node){
        ListNode next = null;
        ListNode pre = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }



    public static ListNode reverse_rec(ListNode node){
        if(node ==null||node.next ==null){
            return node;
        }
        ListNode tmp = node.next;
        ListNode newHead = reverse_rec(node.next);
        tmp.next = node;
        node.next=null;
        return newHead;
    }
}
