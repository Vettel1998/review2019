package algorithm.to_offer;

public class offer23 {

    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] a,int low,int high){
        if (low>=high) return true;
        int i = high;
        while (i>low&&a[i-1]>a[high]) --i;
        for (int j = i-1;j>=low;j--){
            if (a[j]>a[high])
                return false;
        }

        return judge(a,low,i-1)&&judge(a,i,high-1);
    }


}
