package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertSort(int[] a,int n){
        if (n<=1) return;
        for (int i = 1; i <n ; i++) {
            int j = i-1;
            int tmp = a[i];
            for (;j>=0;j--){
                if (a[j]>tmp){
                    a[j+1] = a[j];
                }else break;
            }
            a[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        insertSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
