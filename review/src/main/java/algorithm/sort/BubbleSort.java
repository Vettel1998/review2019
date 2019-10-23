package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
   public static void bubbleSort(int[] a ,int n){
      if(n<=1)
          return;
       for (int i = 0; i<n-1 ; i++) {
           boolean flag = false;
           for (int j = 0; j <n-i-1 ; j++) {
               if (a[j]>a[j+1]){
                   int tmp = a[j];
                   a[j] = a[j+1];
                   a[j+1] = tmp;
                   flag = true;
               }
           }
           if (!flag) break;
       }

   }

    public static void main(String[] args) {
        int[] a = {10,5,2,1,5,4,3,8,9};
        bubbleSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
