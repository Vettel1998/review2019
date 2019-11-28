package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
       求二叉树的最大深度
 */
public class LeetCode104 {
    public static int maxDepthDFS(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right))+1;
    }

    public static int maxDepthBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }

        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int len = queue.size();
            for (int i = 0; i <len ; i++) {
                TreeNode t = queue.poll();
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
            }
        }


        return depth;
    }




}
