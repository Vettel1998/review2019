package algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] a ,int n ){
        if (n<=1) return;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n; j++) {
                if (a[i]>a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6,5,2,3,1,10};
        selectSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
