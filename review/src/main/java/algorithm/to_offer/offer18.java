package algorithm.to_offer;

import algorithm.to_offer.offer04.TreeNode;

public class offer18 {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
