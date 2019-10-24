package algorithm;

public class Utils {
    public static void swapInt(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int partition(int[] nums,int low,int high){
        int povit = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j]<povit){
                Utils.swapInt(nums,i,j);
                i++;
            }
        }
        Utils.swapInt(nums,i,high);
        return i;
    }

    public static void merge(int[] nums,int low,int mid,int high){
        int[] tmp = new int[high-low+1];
        int p = low;
        int q = mid+1;
        int k =0;
        while (p<=mid&&q<=high){
            if (nums[p]<nums[q]){
                tmp[k++] = nums[p++];
            }else tmp[k++] = nums[q++];
        }

        int start= p;
        int end = mid;
        if (q<=high){
            start = q;
            end = high;
        }
        for (int i = start; i <=end; i++) {
            tmp[k++] = nums[i];
        }

        for (int i = 0; i <tmp.length ; i++) {
            nums[low+i] = tmp[i];
        }

    }
}
