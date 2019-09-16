package lambda;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Calc calc = (m,n)->m+n;
        Calc calc1 = Integer::sum;


        MyArrays myArrays = Arrays::sort;
    }
}


interface Calc{
    int sum(int m,int n);

}

interface MyArrays{
    void sort(int[] arr);
}