package BinarySearch;

/*
    查找第一个大于等于给定值的元素
 */
public class FirstGE {
    public static int bsearch(int[] a,int n,int value){
        int low  = 0;
        int high = n-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if (a[mid]<value){
                low = mid+1;
            }else {
                if (mid == 0||a[mid-1]<value) return mid;
                high = mid-1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a = {3,4,6,7,10};
        int res = bsearch(a,a.length,5);
        System.out.println(res);
    }
}
