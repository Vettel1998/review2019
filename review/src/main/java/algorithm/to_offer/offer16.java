package algorithm.to_offer;

import algorithm.to_offer.offer03.ListNode;

public class offer16 {

    public static ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;

            ListNode result = null;
            if (list1.val<list2.val){
                result =list1;
                list1 = list1.next;
            }else {
                result = list2;
                list2 = list2.next;
            }
            ListNode head = result;
            while (list1!=null && list2!=null){
                if (list1.val>list2.val){
                    result.next = list2;
                    list2 = list2.next;
                }else {
                    result.next = list1;
                    list1 = list1.next;
                }
                result = result.next;
            }

            if (list1 !=null)
                result.next = list1;
            if (list2 !=null)
                result.next = list2;

            return head;

    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(7);

       ListNode listNode =  offer16.Merge(list1,list2);
       while (listNode!=null){
           System.out.print(listNode.val+" -> ");
           listNode = listNode.next;
       }
    }
}
