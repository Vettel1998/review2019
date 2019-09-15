package jvm;


/*
*   调用ClassLoader的loadClass方法加载一个类，并不是对类的主动使用
*
* */
public class MyTest11 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("jvm.CL");
        System.out.println(clazz);
        System.out.println("-----------------");
        clazz = Class.forName("jvm.CL");
        System.out.println(clazz);
    }
}


class CL{
    static {
        System.out.println("CL static block");
    }
}
