package algorithm.to_offer;

import algorithm.to_offer.offer03.ListNode;

import static algorithm.to_offer.offer15.getListNode;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode node){
        return getListNode(node);
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
