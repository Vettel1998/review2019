package algorithm.to_offer.offer04;

public class Offer04 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len = in.length;
        if(len == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        int k =0;
        for (int i = 0; i < len ; i++) {
            if(in[i] == pre[0]){
                k = i;
                break;
            }
        }

        int[] pre_left = new int[k];
        int[] in_left = new int[k];
        int[] pre_right = new int[len-k-1];
        int[] in_right = new int[len-k-1];

        for (int i = 0; i < k ; i++) {
            pre_left[i] = pre[i+1];
            in_left[i] = in[i];
        }

        for(int i = k+1;i<len;i++){
            pre_right[i-k-1] = pre[i];
            in_right[i-k-1] = in[i];
        }

        root.left = reConstructBinaryTree(pre_left,in_left);
        root.right = reConstructBinaryTree(pre_right,in_right);

        return root;
    }
}
