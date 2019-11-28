package LinkedList;

import java.util.Stack;

/**
 * CS_Notes_LinkedList07. 链表求和
 * LeetCode445. Add Two Numbers II (Medium)
 */
public class CS_Notes_LinkedList07 {

    //
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        while (!s1.empty()||!s2.empty()||carry!=0){
            int num1  = s1.empty()?0:s1.pop();
            int num2  = s2.empty()?0:s2.pop();
            int sum = num1+num2+carry;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = head.next;
            head.next = newNode;
            carry=sum/10;
        }

        return head.next;

    }

}
