package algorithm.to_offer;


//从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import algorithm.to_offer.offer04.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current =null;
        while (!queue.isEmpty()){
            current = queue.poll();
            result.add(current.val);
            if (current.left!=null)
                queue.offer(current.left);
            if (current.right!=null)
                queue.offer(current.right);
        }

        return result;
    }
}
