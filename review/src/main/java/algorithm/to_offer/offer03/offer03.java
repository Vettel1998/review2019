package algorithm.to_offer.offer03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class offer03 {

    //自己的版本　　　
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<ListNode> result = new ArrayList<>();
        while(listNode != null){
            result.add(listNode);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = result.size()-1; i >=0 ; i--) {
            ret.add(result.get(i).val);
        }

        return ret;
    }

    //version1   Stack
    public ArrayList<Integer> version1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }


    //version2   Collections.reverse
    public ArrayList<Integer> version2(ListNode listNode){
        ArrayList<Integer> result = new ArrayList<>();
        while(listNode!=null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);

        return result;
    }

}
