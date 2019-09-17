package javase;

import java.lang.reflect.Field;

public class StringDemo2 {
    public static void main(String[] args) throws Exception {
        String hello="hello world";
        String xx=new String("hello world");
        String yy="hello world";

        //输出判断内存地址是否相等
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello : "+ (yy==hello)+"\n");

        //通过反射修改hello的value值
        Field hello_field=String.class.getDeclaredField("value");
        hello_field.setAccessible(true);
        char[] value=(char[])hello_field.get(hello);
        value[5]='_';

        //首先输出修改结果
        System.out.println("Hello: "+hello+"\n");

        //然后判断内存地址是否有变化
        System.out.println("xx==hello : "+ (xx==hello));
        System.out.println("yy==hello:"+(hello==yy));
        System.out.println("xx==yy:"+(xx==yy)+"\n");

        //最后输出所有值的结果
        System.out.println("xx: "+xx);
        System.out.println("yy: "+yy);
        System.out.println("Hello: "+hello);
    }
}
