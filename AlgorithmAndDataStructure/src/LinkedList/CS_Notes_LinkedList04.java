package LinkedList;

/**
 *  CS_Notes4. 从有序链表中删除重复节点
 *  leetcode83. Remove Duplicates from Sorted List (Easy)
 */
public class CS_Notes_LinkedList04 {

    //递归
    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null||head.next == null) return head;
        head.next = deleteDuplicatesRecur(head.next);
        return head.val == head.next.val ? head.next : head;
    }


    //O(n)
    public ListNode deleteDuplicates(ListNode head){
        ListNode current = head;
        while (current!=null&&current.next!=null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }

        }

        return head;
    }

}
