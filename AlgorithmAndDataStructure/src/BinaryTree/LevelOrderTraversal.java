package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
       if (root==null) return new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       Queue<TreeNode> curLevel = new LinkedList<>();
       while (!queue.isEmpty()){
           curLevel.offer(queue.poll());
           if (queue.isEmpty()){
               List<Integer> list = new ArrayList<>();
               while (!curLevel.isEmpty()){
                   TreeNode cur = curLevel.poll();
                   list.add(cur.val);
                   if (cur.left!=null) queue.offer(cur.left);
                   if (cur.right!=null) queue.offer(cur.right);
               }
               result.add(list);
           }
       }

       return result;
    }
}
