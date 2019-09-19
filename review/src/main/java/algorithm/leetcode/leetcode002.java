package algorithm.leetcode;

import algorithm.to_offer.offer03.ListNode;

import java.util.List;

public class leetcode002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val+l2.val;
        int count = 0;
        if(sum>=10){
            sum-=10;
            count=1;
        }
        l1 = l1.next;
        l2= l2.next;
        ListNode result = new ListNode(sum);
        ListNode res = result;
        while (l1!=null||l2!=null){
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) num1=l1.val;
            if (l2 !=null) num2=l2.val;
            sum = num1+num2+count;
            if (sum>=10){
                sum-=10;
                count=1;
            }else count=0;
            result.next = new ListNode(sum);
            result = result.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;

        }
        if (count>0)
            result.next = new ListNode(count);
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);
    }
}
