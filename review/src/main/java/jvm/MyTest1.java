package jvm;


/*
* 1.对于静态字段 只有直接定义该字段的类才会被初始化
*
*
* */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        System.out.println(MyChild1.str2);
    }
}


class MyParent1{
    public static String str= "helloworld";
    static {
        System.out.println("MyParent static block");
    }
}



class MyChild1 extends MyParent1{
    public static String str2 = "Hello";
    static {
        System.out.println("MyChild static block");
    }
}
