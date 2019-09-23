package javase.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        /*int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.asList(nums).get(0).getClass());
        System.out.println(Arrays.asList(nums).contains(nums));
        System.out.println(testInt(1));
        System.out.println(testInteger(1) );*/

        List<String> list = Arrays.asList("aa","bb","cc");
        Object[] objects = list.toArray();
        objects[0] = new Object();

    }

    public static boolean testInteger(Integer num){
        Integer[] nums = new Integer[]{1,2,3,4};
        boolean flag = Arrays.asList(nums).contains(num);
        return flag;
    }

    public static boolean testInt(int num){
        int[] nums = new int[]{1,2,3,4,5};
        boolean flag = Arrays.asList(nums).contains(num);
        return flag;
    }
}
