package jvm;

/*
*   常量传播优化
*
*
*
* */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.a);
    }
}


class MyParent2{
    public static String str1 = "hello1";
    public static final String str2 = "hello2";
    public static final int a =1;

    static {
        System.out.println("MyParent2 static block");
    }
}
