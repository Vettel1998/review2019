package algorithm.to_offer;

import algorithm.to_offer.offer03.ListNode;

public class offer14 {
    int a = 0;
    String s = "";

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i <k; i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new offer14().toString());
    }
    @Override
    public String toString() {
        return "offer14{" +
                "a=" + a +
                ", s='" + s + '\'' +
                '}';
    }


}




