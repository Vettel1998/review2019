package jvm;

/*
*       扩展类加载器
*       需要把class文件打成jar包
*
* */
public class MyTest21 {
    public static void main(String[] args) {
        System.out.println(MyTest1.class.getClassLoader());
    }
}
