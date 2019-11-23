package BinaryTree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = root;
        TreeNode parent = null;

        //Find target treenode
        while (target!=null&&target.val!=key){
            parent = target;
            if (target.val<key) target = target.right;
            else target = target.left;
        }
        if (target == null) return root;


        //Delete target treenode
        while (target.left!=null&&target.right!=null){
            TreeNode minTarget = target.right;
            TreeNode minParent = target;
            while (minTarget.left!=null){
                minParent = minTarget;
                minTarget = minTarget.left;
            }
            target.val = minTarget.val;
            target = minTarget;
            parent = minParent;
        }

        TreeNode child = null;
        if (target.left!=null) child = target.left;
        else if (target.right!=null) child = target.right;

        if (parent==null)  return child;
        if (target == parent.left) parent.left = child;
        if (target == parent.right) parent.right = child;


        return root;

    }


}
